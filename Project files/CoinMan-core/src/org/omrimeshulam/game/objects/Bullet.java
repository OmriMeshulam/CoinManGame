package org.omrimeshulam.game.objects;

import org.omrimeshulam.game.tools.TextureManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Bullet extends GameObjs {
	Rectangle box;
	Sprite sprite;
	//Texture texture;	
	
	public Bullet (int x, int y){
		box = new Rectangle(x,y,34,24); 
		sprite = new Sprite(TextureManager.bullet, 0, 0, 34, 24); // starting point
		setPosition(x,y);
	}
	
	@Override
	public int hits(Rectangle r) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public void action(int type, float x, float y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosition(float x, float y) {
		this.box.x = x;
		this.box.y = y;
		sprite.setPosition(x, y);
	}

	@Override
	public void moveLeft(float delta) {
		box.x -=(150 * delta);
		sprite.setPosition(box.x, box.y);

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
		return box;
	}

	@Override
	public int hitAction(int side) {
		if (side == 1) {return 5;}
		return 2;
	}

	@Override
	public TextureRegion currentFrame() {
		// TODO Auto-generated method stub
		return null;
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
