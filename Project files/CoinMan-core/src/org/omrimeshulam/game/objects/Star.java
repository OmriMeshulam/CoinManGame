package org.omrimeshulam.game.objects;

import org.omrimeshulam.game.tools.TextureManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Star extends GameObjs{
	Rectangle Box;
	Sprite sprite;
	private static final int STAR_FRAME_COLS = 8; 
	private static final int STAR_FRAME_ROWS = 1;  
	
	Animation starAnimation;
	TextureRegion[] starFrames;
	TextureRegion currentFrame;
	float stateTime = 0.0f;
	
	
	public Star(int x, int y){
        TextureRegion[][] tmp = TextureRegion.split(TextureManager.starSheet, TextureManager.starSheet.getWidth()/STAR_FRAME_COLS, TextureManager.starSheet.getHeight()/STAR_FRAME_ROWS);
		starFrames = new TextureRegion[STAR_FRAME_COLS * STAR_FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < STAR_FRAME_ROWS; i++) {
            for (int j = 0; j < STAR_FRAME_COLS; j++) {
                starFrames[index++] = tmp[i][j];
            }
        }
        starAnimation = new Animation(0.025f, starFrames);
        currentFrame = starAnimation.getKeyFrame(stateTime, true);
        
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
		stateTime += delta/3;
		currentFrame = starAnimation.getKeyFrame(stateTime, true);
		
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
