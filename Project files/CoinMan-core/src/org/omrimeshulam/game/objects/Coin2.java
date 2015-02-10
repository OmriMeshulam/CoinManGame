package org.omrimeshulam.game.objects;

import org.omrimeshulam.game.tools.TextureManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Coin2 extends GameObjs{
	Rectangle Box;
	Sprite sprite;
	private static final int COIN_FRAME_COLS = 8; 
	private static final int COIN_FRAME_ROWS = 8;  
	
	Animation coinAnimation;
	TextureRegion[] coinFrames;
	TextureRegion currentFrame;
	float stateTime = 0.0f;
	
	
	public Coin2(int x, int y){
        TextureRegion[][] tmp = TextureRegion.split(TextureManager.coinSheet, TextureManager.coinSheet.getWidth()/COIN_FRAME_COLS, TextureManager.coinSheet.getHeight()/COIN_FRAME_ROWS);
		coinFrames = new TextureRegion[COIN_FRAME_COLS * COIN_FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < COIN_FRAME_ROWS; i++) {
            for (int j = 0; j < COIN_FRAME_COLS; j++) {
                coinFrames[index++] = tmp[i][j];
            }
        }
        coinAnimation = new Animation(0.025f, coinFrames);
        currentFrame = coinAnimation.getKeyFrame(stateTime, true);
        
		Box = new Rectangle(0, 0, 20, 20);

		setPosition(x,y);
	}
	
	@Override
	public int hits(Rectangle r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void action(int type, float x, float y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(float delta) {
		stateTime += delta;
		currentFrame = coinAnimation.getKeyFrame(stateTime, true);
		
	}
	
	public TextureRegion currentFrame(){
		return currentFrame;
	}

	@Override
	public void setPosition(float x, float y) {
		// TODO Auto-generated method stub
		Box.x = x;
		Box.y = y;
		
	}

	@Override
	public void moveLeft(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveRight(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(SpriteBatch batch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getHitBox() {
		// TODO Auto-generated method stub
		
		return Box;
		
		
	}

	@Override
	public int hitAction(int side) {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public float getTimer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTimer(float newTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void resetPosition() {
		// TODO Auto-generated method stub
		
	}
	
}
