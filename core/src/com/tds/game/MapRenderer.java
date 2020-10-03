package com.tds.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

import java.util.ArrayList;
import java.util.HashMap;

public class MapRenderer {

    private static final float HEX_WIDTH = 200f;
    private static final float HEX_HEIGHT = 150f;

    private HashMap<String, Texture> terrainTextures;

    public MapRenderer() {
        initializeTerrainTextures();
    }

    private void initializeTerrainTextures() {
        terrainTextures = new HashMap<>();
        Json json = new Json();
        ArrayList<JsonValue> listOfTypeToTextureMappings = json.fromJson(ArrayList.class,
                Gdx.files.internal("terrain/terrain_type_to_image_mappings.json") );
        for ( JsonValue jsonTypeToTextureMapping : listOfTypeToTextureMappings ) {
            TerrainTypeToImageMapping mapping = json.readValue( TerrainTypeToImageMapping.class, jsonTypeToTextureMapping );
            terrainTextures.put( mapping.getType(), new Texture ( Gdx.files.internal( mapping.getTexturePath() ) ) );
        }
    }

    /**
     * Map origin is at the bottom left of the screen.
     * // TODO: >> cnh >> Do we want to render from the top left instead?
     *
     * @param map - The Map being rendered
     * @param client - The GameClient that we are running.
     */
    public void renderMapForClient(GameMap map, SummerGameClient client ) {
        client.getSpriteBatch().setProjectionMatrix( client.getGameCamera().combined );
        client.getSpriteBatch().begin();
        for( int mapX = 0; mapX < map.getMapData().length; mapX++ ) {
            for( int mapY = 0; mapY < map.getMapData()[0].length; mapY++ ) {
                MapData mapData = map.getMapData()[mapX][mapY];
                Texture hexToDraw = getTextureForMapData( mapData );

                float screenY = HEX_HEIGHT * mapY;
                float screenX = HEX_WIDTH * mapX;
                if( isOddRow( mapY ) ) {
                    screenX = HEX_WIDTH * mapX + HEX_WIDTH / 2;
                }

                client.getSpriteBatch().draw( hexToDraw, screenX, screenY );
            }
        }
        client.getSpriteBatch().end();
    }

    private Texture getTextureForMapData( MapData mapData ) {
        return terrainTextures.get( mapData.getTerrain().getType() );
    }

    private boolean isOddRow( int row ) {
        return row % 2 == 1;
    }

}
