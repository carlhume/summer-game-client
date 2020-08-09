package com.tds.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class CompanySplashScreen extends ScreenAdapter {

    private SummerGameClient game;
    private Texture img;

    public CompanySplashScreen( SummerGameClient game ) {
        this.game = game;
        img = new Texture("MadeByTDS.png");
    }

    @Override
    public void render ( float delta ) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getSpriteBatch().begin();
        game.getSpriteBatch().draw(img, 0, 0);
        game.getSpriteBatch().end();
    }

    @Override
    public void dispose () {
        img.dispose();
    }

}
