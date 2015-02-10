package org.omrimeshulam.game.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundManager {
	
	public static Sound jump;
	public static Sound coin;
	public static Sound death ;
	public static Music stage;
	public static Music gameOver;
	public static Music worldClear;
	public static Music starTheme;
	public static Sound enemyStomp;
	
	public static Music background;
	
	public static void create() {
		jump = Gdx.audio.newSound(Gdx.files.internal("sound/jump.mp3"));
		coin = Gdx.audio.newSound(Gdx.files.internal("sound/coin.mp3"));
		death = Gdx.audio.newSound(Gdx.files.internal("sound/mario_die.mp3"));
		stage = Gdx.audio.newMusic(Gdx.files.internal("sound/stage_clear.mp3"));
		background = Gdx.audio.newMusic(Gdx.files.internal("sound/background.mp3"));
		gameOver = Gdx.audio.newMusic(Gdx.files.internal("sound/gameover.mp3"));
		worldClear = Gdx.audio.newMusic(Gdx.files.internal("sound/world_clear.mp3"));
		starTheme = Gdx.audio.newMusic(Gdx.files.internal("sound/starTheme.mp3"));
		enemyStomp = Gdx.audio.newSound(Gdx.files.internal("sound/smb3_stomp.wav"));
	}

	public static void dispose() {
		jump.dispose();
		coin.dispose();
		death.dispose();
		stage.dispose();
		background.dispose();
		gameOver.dispose();
		worldClear.dispose();
		enemyStomp.dispose();
		starTheme.dispose();
		
	}
	
	public static void pauseAll(){
		SoundManager.background.pause();
		SoundManager.jump.pause();
		SoundManager.coin.pause();
		SoundManager.death.pause();
		SoundManager.stage.pause();
		SoundManager.worldClear.pause();
		SoundManager.gameOver.pause();
		SoundManager.enemyStomp.pause();
		SoundManager.starTheme.pause();
	}
}
