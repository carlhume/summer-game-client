package com.tds.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Scaling;

import java.util.HashMap;
import java.util.logging.Logger;

public class MapScreen extends ScreenAdapter {

    private static final Logger logger = Logger.getLogger( MapScreen.class.getName() );

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

    /**
     * Map origin is at the bottom left of the screen.
     * // TODO: >> cnh >> Do we want to render from the top left instead?
     *
     * @param delta
     */
    @Override
    public void render ( float delta ) {
        clearScreen();
        game.getSpriteBatch().begin();
        for( int mapX = 0; mapX < this.map.getMapData().length; mapX++ ) {
            for( int mapY = 0; mapY < this.map.getMapData()[0].length; mapY++ ) {
                float screenX = HEX_WIDTH * mapX;
                if( isOddRow( mapY ) ) {
                    screenX = HEX_WIDTH * mapX + HEX_WIDTH / 2;
                }

                float screenY = HEX_HEIGHT * mapY;

                MapData mapData = this.map.getMapData()[mapX][mapY];
                game.getSpriteBatch().draw( getTextureForMapData( mapData ), screenX, screenY );
                logger.info( "FPS: " + Gdx.graphics.getFramesPerSecond() );
            }
        }
        game.getSpriteBatch().end();
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private Texture getTextureForMapData( MapData mapData ) {
        return terrainTextures.get( mapData.getTerrain().getType() );
    }

    private boolean isOddRow( int row ) {
        return row % 2 == 1;
    }

}
