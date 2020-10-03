package com.tds.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

import java.util.ArrayList;
import java.util.HashMap;

public class PopCenterRenderer {

    private HashMap<String, Texture> popCenterTextures;
    private SummerGameClient client;

    public PopCenterRenderer( SummerGameClient game ) {
        this.client = game;
        initializePopCenterTextures();
    }

    private void initializePopCenterTextures() {
        popCenterTextures = new HashMap<>();
        Json json = new Json();
        ArrayList<JsonValue> listOfTypeToTextureMappings = json.fromJson(ArrayList.class,
                Gdx.files.internal("pop_centers/pop_center_type_to_image_mappings.json") );
        for ( JsonValue jsonTypeToTextureMapping : listOfTypeToTextureMappings ) {
            TypeToImageMapping mapping = json.readValue( TypeToImageMapping.class, jsonTypeToTextureMapping );
            popCenterTextures.put( mapping.getType(), new Texture ( Gdx.files.internal( mapping.getTexturePath() ) ) );
        }
    }

    public void renderPopCenterAtCoordinates(PopCenter popCenter, float screenX, float screenY ) {
        Texture popCenterTexture = popCenterTextures.get( popCenter.getType() );
        // Adjust screen coordinates to center on the size of the texture
        screenY = screenY - ( popCenterTexture.getHeight() / 2f );
        screenX = screenX - ( popCenterTexture.getWidth() / 2f );
        client.getSpriteBatch().draw( popCenterTexture, screenX, screenY );
    }

}
