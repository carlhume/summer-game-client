package com.tds.game.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.tds.game.SummerGameClient;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle( "Summer Game Client" );
		config.setWindowedMode(1024, 768 );
		new Lwjgl3Application(new SummerGameClient(), config);
	}
}
