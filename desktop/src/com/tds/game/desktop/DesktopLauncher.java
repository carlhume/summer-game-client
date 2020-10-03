package com.tds.game.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.tds.game.SummerGameClient;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DesktopLauncher {

	private static final Logger logger = Logger.getLogger( DesktopLauncher.class.getName() );

	public static void main (String[] arg) {
		try {
			Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
			config.setTitle("Summer Game Client");
			config.setWindowedMode(1024, 768);
			new Lwjgl3Application(new SummerGameClient(), config);
		} catch( Exception anythingWrong ) {
			logger.log( Level.SEVERE, "There was a Fatal Exception thrown by the game", anythingWrong );
		}
	}
}
