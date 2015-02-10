package org.omrimeshulam.game.objects;

import org.omrimeshulam.game.tools.TextureManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class MysteryBox extends GameObjs {
	Rectangle Box;
	Sprite sprite;
	private static final int MYSTERY_BOX_FRAME_COLS = 5; 
	private static final int MYSTERY_BOX_FRAME_ROWS = 3;  
	
	Animation boxAnimation;
	TextureRegion[] boxFrames;
	TextureRegion currentFrame;
	float stateTime = 0.0f;
	
	public MysteryBox (int x, int y){
		 TextureRegion[][] tmp = TextureRegion.split(TextureManager.mysteryBox, TextureManager.mysteryBox.getWidth()/MYSTERY_BOX_FRAME_COLS, TextureManager.mysteryBox.getHeight()/MYSTERY_BOX_FRAME_ROWS);
		 boxFrames = new TextureRegion[MYSTERY_BOX_FRAME_COLS * MYSTERY_BOX_FRAME_ROWS];
	        int index = 0;
	        for (int i = 0; i < MYSTERY_BOX_FRAME_ROWS; i++) {
	            for (int j = 0; j < MYSTERY_BOX_FRAME_COLS; j++) {
	            	boxFrames[index++] = tmp[i][j];
	            }
	        }
	        boxAnimation = new Animation(0.025f, boxFrames);
	        currentFrame = boxAnimation.getKeyFrame(stateTime, true);
	        
			Box = new Rectangle(0, 0, 16, 16);

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
		//System.out.println("Box.getX(): " + Box.getX() + " Box.getY(): " + Box.getY() + " Box.getHeight(): " + Box.getHeight() + " Box.getWidth(): " + Box.getWidth());

		stateTime += delta /4;
		currentFrame = boxAnimation.getKeyFrame(stateTime, true);
		
	}

	@Override
	public void setPosition(float x, float y) {
		Box.x = x;
		Box.y = y;
	}

	@Override
	public void moveLeft(float delta) {

	}

	@Override
	public void moveRight(float delta) {

	}

	@Override
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
		
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
		if (side == 4) {
			return 6;
		}else { 
			return 1; 
			}
	}

	@Override
	public TextureRegion currentFrame() {
		return currentFrame;
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
