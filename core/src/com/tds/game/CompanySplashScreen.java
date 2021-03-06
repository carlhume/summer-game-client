package com.tds.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;

public class CompanySplashScreen extends ScreenAdapter {

    private SummerGameClient game;
    private Texture companySplashImage;

    public CompanySplashScreen( SummerGameClient game ) {
        this.game = game;
        companySplashImage = new Texture("MadeByTDS.png");
    }

    @Override
    public void render ( float delta ) {
        game.getSpriteBatch().begin();
        game.getSpriteBatch().draw( companySplashImage, 0, 0 );
        game.getSpriteBatch().end();
    }

    @Override
    public void dispose () {
        companySplashImage.dispose();
    }

}
