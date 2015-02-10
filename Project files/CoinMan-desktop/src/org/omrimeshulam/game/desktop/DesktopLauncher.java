package org.omrimeshulam.game.desktop;

import org.omrimeshulam.game.CoinManGame;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "CoinMan Adventures!";
		config.useGL30 = false;
		config.width = 800;
		config.height = 400;
		
		new LwjglApplication(new CoinManGame(), config);
	}
}
