package com.tds.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class MapScreen extends ScreenAdapter {

    private static final float HEX_WIDTH = 110f;
    private static final float HEX_HEIGHT = 125f;

    private SummerGameClient game;
    private GameMap map;

    public MapScreen( SummerGameClient game ) {
        this.game = game;
        this.map = game.loadGameMap();
    }

    @Override
    public void render ( float delta ) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getSpriteBatch().begin();
        game.getFont().getData().setScale( 10 );
        for( int mapX = 0; mapX < this.map.getMapData().length; mapX++ ) {
            for( int mapY = 0; mapY < this.map.getMapData()[0].length; mapY++ ) {
                String terrainType = this.map.getMapData()[mapX][mapY].getTerrain().getType();
                float screenX = HEX_WIDTH * mapX;
                if( isEvenRow( mapY ) ) {
                    screenX = HEX_WIDTH * mapX + HEX_WIDTH / 2;
                }

                float screenY = Gdx.graphics.getHeight() * .95f - mapY * HEX_HEIGHT;

                game.getFont().draw( game.getSpriteBatch(), terrainType, screenX, screenY );
            }
        }
        game.getSpriteBatch().end();
    }


    private boolean isEvenRow( int row ) {
        return row % 2 == 0;
    }

}
