package com.tds.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

public class SummerGameClient extends Game {

	private SpriteBatch batch;
	private BitmapFont font;
	private OrthographicCamera camera;

	private CompanySplashScreen companySplashScreen;
	private MapScreen mapScreen;
	private Clock clock;

	@Override
	public void create () {
		this.batch = new SpriteBatch();
		this.font = new BitmapFont();
		this.clock = new Clock();

		camera = new OrthographicCamera( Gdx.graphics.getWidth(), Gdx.graphics.getHeight()) ;
		camera.position.set(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f, 0);
		camera.update();

		// Create screens at the end, as they may rely on game resources ...
		this.companySplashScreen = new CompanySplashScreen( this );
		this.mapScreen = new MapScreen( this );
		showCompanySplashScreen();
		showScreenAfterDelay( mapScreen, 2 );
	}

	private void showScreenAfterDelay( final Screen screen, long delayInSeconds ) {
		Timer.schedule(new Timer.Task(){
			@Override
			public void run() {
				setScreen( screen );
			}
		}, delayInSeconds );
	}

	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
	}

	public GameMap loadGameMap() {
		// TODO : Should be loading the game map based on the selected game
		MapLoader loader = new MapLoader();
		return loader.loadMap( 116 );
	}

	public void showCompanySplashScreen() {
		setScreen( companySplashScreen );
	}

	public SpriteBatch getSpriteBatch() {
		return this.batch;
	}

	public BitmapFont getFont() {
		return this.font;
	}

	public Clock getClock() {
		return this.clock;
	}

	public OrthographicCamera getCamera() { return this.camera; }
}
