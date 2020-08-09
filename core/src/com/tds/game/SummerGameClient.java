package com.tds.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SummerGameClient extends Game {

	private SpriteBatch batch;
	private BitmapFont font;
	private CompanySplashScreen companySplashScreen;
	private MapScreen mapScreen;
	private Clock clock;

	@Override
	public void create () {
		this.batch = new SpriteBatch();
		this.font = new BitmapFont();
		this.clock = new Clock();

		// Create screens at the end, as they may rely on game resources ...
		this.companySplashScreen = new CompanySplashScreen( this );
		this.mapScreen = new MapScreen( this );
		showCompanySplashScreen();
	}

	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
	}

	public void showCompanySplashScreen() {
		setScreen( companySplashScreen );
	}

	public void showMapScreen() {
		setScreen( mapScreen );
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
}
