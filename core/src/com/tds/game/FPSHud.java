package com.tds.game;

import com.badlogic.gdx.Gdx;

public class FPSHud {

    /**
     * Draws the current frames per second count in the top left hand corner of the game screen.
     * @param client - the Game Client we are running.
     */
    public void renderForClient( SummerGameClient client ) {
        client.getHudCamera().update();
        client.getSpriteBatch().setProjectionMatrix(client.getHudCamera().combined);
        client.getSpriteBatch().begin();
        client.getFont().draw(client.getSpriteBatch(), "Debug Mode, FPS=" + Gdx.graphics.getFramesPerSecond(),
                            0, client.getHudCamera().viewportHeight);
        client.getSpriteBatch().end();
    }

}
