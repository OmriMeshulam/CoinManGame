package org.omrimeshulam.game.objects;

import org.omrimeshulam.game.tools.TextureManager;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Cloud extends GameObjs{
	Sprite sprite;
	
	public Cloud(float x, float y){
		sprite = new Sprite(TextureManager.cloud,0,0,136,66);
		this.setPosition(x, y);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosition(float x, float y) {
		sprite.setPosition(x, y);
		
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
		sprite.draw(batch);
		
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getHitBox() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int hitAction(int side) {
		// TODO Auto-generated method stub
		return 0;
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
