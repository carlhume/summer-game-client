package com.tds.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SummerGameClient extends Game {

	private SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen( new CompanySplashScreen( this ) );
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

	public SpriteBatch getSpriteBatch() {
		return this.batch;
	}
}
