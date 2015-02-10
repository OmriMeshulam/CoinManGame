package org.omrimeshulam.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObjs {
	public abstract TextureRegion currentFrame();
	public abstract int hits(Rectangle r);
	public abstract void action(int type, float x, float y);
	public abstract void update(float delta);
	public abstract void setPosition(float x, float y);
	public abstract void moveLeft(float delta);
	public abstract void moveRight(float delta);
	public abstract void draw(SpriteBatch batch);
	public abstract void jump();
	public abstract Rectangle getHitBox();
	public abstract int hitAction(int side);
	public abstract float getTimer();
	public abstract void setTimer(float newTime);
	public abstract float getSize();
	public abstract void resetPosition();
}
