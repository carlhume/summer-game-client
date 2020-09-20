package com.tds.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

import java.util.logging.Logger;

public class MapScreen extends ScreenAdapter {

    private static final Logger logger = Logger.getLogger( MapScreen.class.getName() );

    private SummerGameClient game;
    private GameMap map;
    private MapRenderer mapRenderer;
    private FPSHud hud;

    public MapScreen( SummerGameClient game ) {
        this.game = game;
        this.map = game.loadGameMap();
        this.hud = new FPSHud();
        this.mapRenderer = new MapRenderer();
    }

    @Override
    public void render ( float delta ) {
        clearScreen();
        updateCamera();
        mapRenderer.renderMapForClient( map, game );
        hud.renderForClient( game );
    }

    private void updateCamera() {

        float moveSpeed = 200f;
        float zoomSpeed = 1f;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            game.getGameCamera().translate(0, moveSpeed * Gdx.graphics.getDeltaTime());
            logger.finest( "Moving camera Up" );
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            game.getGameCamera().translate(0, -moveSpeed * Gdx.graphics.getDeltaTime());
            logger.finest( "Moving camera Down" );
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            game.getGameCamera().translate(-moveSpeed * Gdx.graphics.getDeltaTime(), 0);
            logger.finest( "Moving camera Left" );
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            game.getGameCamera().translate(moveSpeed * Gdx.graphics.getDeltaTime(), 0);
            logger.finest( "Moving camera Right" );
        }

        if(Gdx.input.isKeyPressed((Input.Keys.UP))){
            game.getGameCamera().zoom -= zoomSpeed * Gdx.graphics.getDeltaTime();
            logger.finest( "Zooming camera in" );
        } else if(Gdx.input.isKeyPressed((Input.Keys.DOWN))){
            game.getGameCamera().zoom += zoomSpeed * Gdx.graphics.getDeltaTime();
            logger.finest( "Zooming camera out" );
        }

        game.getGameCamera().update();
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}
