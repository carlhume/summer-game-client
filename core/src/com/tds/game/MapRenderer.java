package com.tds.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

public class MapRenderer {

    private static final float HEX_WIDTH = 200f;
    private static final float HEX_HEIGHT = 150f;

    private HashMap<String, Texture> terrainTextures;

    public MapRenderer() {
        this.terrainTextures = new HashMap<>();

        // TODO: >> cnh >> Consider loading these from configuration
        this.terrainTextures.put( "P", new Texture ( Gdx.files.internal("terrain/plains_hex.png" ) ) );
        this.terrainTextures.put( "F", new Texture ( Gdx.files.internal("terrain/forest_hex.png" ) ) );
        this.terrainTextures.put( "M", new Texture ( Gdx.files.internal("terrain/mountain_hex.png" ) ) );
        this.terrainTextures.put( "D", new Texture ( Gdx.files.internal("terrain/desert_hex.png" ) ) );
        this.terrainTextures.put( "W", new Texture ( Gdx.files.internal("terrain/water_hex.png" ) ) );
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
