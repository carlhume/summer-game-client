package com.tds.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.tds.game.SummerGameClient;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Summer Game Client";
		config.width = 1024;
		config.height = 768;
		new LwjglApplication(new SummerGameClient(), config);
	}
}
