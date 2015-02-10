package org.omrimeshulam.game.objects;

import org.omrimeshulam.game.tools.TextureManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Cannon extends GameObjs{
	Rectangle box;
	Sprite sprite;
	float bulletSpawnTimer;
	//Texture texture;	
	
	public Cannon(int x, int y){
		box = new Rectangle(0,0,48,49);
		sprite = new Sprite(TextureManager.cannon, 0, 0, 48,49);
		setPosition(x, y);
		bulletSpawnTimer = 0;
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
		bulletSpawnTimer += 50 * delta;		
	}

	@Override
	public void setPosition(float x, float y) {
		box.x = x;
		box.y = y;
		sprite.setPosition(x,y);
		
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
		return box;
	}

	@Override
	public int hitAction(int side) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public TextureRegion currentFrame() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getTimer() {
		// TODO Auto-generated method stub
		return bulletSpawnTimer;
	}

	@Override
	public void setTimer(float newTime) {
		bulletSpawnTimer = newTime;
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
