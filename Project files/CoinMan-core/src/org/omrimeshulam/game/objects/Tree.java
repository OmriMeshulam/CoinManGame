package org.omrimeshulam.game.objects;

import org.omrimeshulam.game.tools.TextureManager;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Tree extends GameObjs{
	Rectangle Box;
	Sprite sprite;
	private static final int TREE_FRAME_COLS = 3; 
	private static final int TREE_FRAME_ROWS = 2;  
	
	Animation treeAnimation;
	TextureRegion[] treeFrames;
	
	TextureRegion currentFrame;
	float stateTime = 0.0f;
	float size;
	int defaultX, defaultY;

	public Tree (float x, float y, float size){
		this.size = size/10;
		defaultX = (int)x;
		defaultY = (int)y;
		TextureRegion[][] tmp = TextureRegion.split(TextureManager.treeSheet, TextureManager.treeSheet.getWidth()/TREE_FRAME_COLS, TextureManager.treeSheet.getHeight()/TREE_FRAME_ROWS);
		treeFrames = new TextureRegion[TREE_FRAME_COLS * TREE_FRAME_ROWS];
			int index = 0;
	        for (int i = 0; i < TREE_FRAME_ROWS; i++) {
	            for (int j = 0; j < TREE_FRAME_COLS; j++) {
	            	treeFrames[index++] = tmp[i][j];
	            }
	        }
	        treeAnimation = new Animation(0.025f, treeFrames);
	        currentFrame = treeAnimation.getKeyFrame(stateTime, true);
	       
	        Box = new Rectangle(0, 0, 150, 114);
	        setPosition(x,y);
	}
	
	@Override
	public TextureRegion currentFrame() {
		return currentFrame;
	}

	@Override
	public int hits(Rectangle r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void action(int type, float x, float y) {
		setPosition(Box.getX() - x/2, Box.getY());
		
	}

	@Override
	public void update(float delta) {
		stateTime += delta/4;
		currentFrame = treeAnimation.getKeyFrame(stateTime, true);
		
		
	}

	@Override
	public void setPosition(float x, float y) {
		Box.x = x;
		Box.y = y;
	}

	@Override
	public void moveLeft(float delta) {
		int speed = 50;
		Box.x -=(speed * delta);
		
		setPosition(Box.x, Box.y);
		
	}

	@Override
	public void moveRight(float delta) {
		int speed = 50;
		Box.x +=(speed * delta);
	
		setPosition(Box.x, Box.y);
		
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
		return 0;
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
		return size;
		
	}
	
	public void resetPosition(){
		setPosition(defaultX,defaultY);
	}

}
