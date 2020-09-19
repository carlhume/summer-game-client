package com.tds.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;

public class MapScreen extends ScreenAdapter {

    private static final float BORDER = 75f;
    private static final float HEX_WIDTH = 200f;
    private static final float HEX_HEIGHT = 150f;

    private SummerGameClient game;
    private GameMap map;
    private HashMap<String, Texture> terrainTextures;

    public MapScreen( SummerGameClient game ) {
        this.terrainTextures = new HashMap<>();
        this.game = game;
        this.map = game.loadGameMap();

        initializeTerrainTextures();
    }

    // TODO: >> cnh >> Load the image to terrain mapping from configuration ...
    private void initializeTerrainTextures() {
        this.terrainTextures.put( "P", new Texture ( Gdx.files.internal("terrain/plains_hex.png" ) ) );
        this.terrainTextures.put( "F", new Texture ( Gdx.files.internal("terrain/forest_hex.png" ) ) );
        this.terrainTextures.put( "M", new Texture ( Gdx.files.internal("terrain/mountain_hex.png" ) ) );
        this.terrainTextures.put( "D", new Texture ( Gdx.files.internal("terrain/desert_hex.png" ) ) );
        this.terrainTextures.put( "W", new Texture ( Gdx.files.internal("terrain/water_hex.png" ) ) );
    }

    @Override
    public void render ( float delta ) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getSpriteBatch().begin();
        game.getFont().getData().setScale( 10 );
        for( int mapX = 0; mapX < this.map.getMapData().length; mapX++ ) {
            for( int mapY = 0; mapY < this.map.getMapData()[0].length; mapY++ ) {
                float screenX = HEX_WIDTH * mapX;
                if( isEvenRow( mapY ) ) {
                    screenX = HEX_WIDTH * mapX + HEX_WIDTH / 2;
                }

                float screenY = Gdx.graphics.getHeight() - mapY * HEX_HEIGHT - HEX_HEIGHT - BORDER;

                MapData mapData = this.map.getMapData()[mapX][mapY];
                renderMapDataAtCoordinates( mapData, screenX, screenY );
            }
        }
        game.getSpriteBatch().end();
    }

    private void renderMapDataAsTextAtCoordinates( MapData mapData, float screenX, float screenY ) {
        String terrainType = mapData.getTerrain().getType();
        game.getFont().draw( game.getSpriteBatch(), terrainType, screenX, screenY );
    }

    private void renderMapDataAtCoordinates( MapData mapData, float screenX, float screenY ) {
        game.getSpriteBatch().draw( getTextureForMapData( mapData ), screenX, screenY );
    }

    private Texture getTextureForMapData( MapData mapData ) {
        return terrainTextures.get( mapData.getTerrain().getType() );
    }

    private boolean isEvenRow( int row ) {
        return row % 2 == 0;
    }

}
