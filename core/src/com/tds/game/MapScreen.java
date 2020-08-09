package com.tds.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class MapScreen extends ScreenAdapter {

    private SummerGameClient game;

    public MapScreen( SummerGameClient game ) {
        this.game = game;
    }

    @Override
    public void render ( float delta ) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getSpriteBatch().begin();
        game.getFont().getData().setScale( 10 );
        game.getFont().draw( game.getSpriteBatch(), "Map Screen", Gdx.graphics.getWidth() * .13f, Gdx.graphics.getHeight() * .75f );
        game.getSpriteBatch().end();
    }

}
