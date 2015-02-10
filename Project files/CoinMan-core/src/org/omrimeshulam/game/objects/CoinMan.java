package org.omrimeshulam.game.objects;

import org.omrimeshulam.game.tools.TextureManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class CoinMan extends GameObjs {
	Rectangle full, bottom, left, right, top;
	private Sprite sprite;
	
	int action;
	float velocityY;
	int starLength = 10; // in seconds
	int normalWalkingPace = 100, fastWalkingPace = 175;
	boolean dir;
	private boolean speedPressed;
	boolean starOn;
	boolean spriteReload;
	boolean isStanding, isDucking;
	final int fLives;
	int lives, coinsCollected, score;
	private int intFatigue;
	int colorRotation;
	private float fatigueLevel;
	float starTime;
	
	public CoinMan(){
		sprite = new Sprite(TextureManager.mario_big_walking_1);
		
		full = new Rectangle(0.0f, 0.0f, 15.0f, 30.0f);
		bottom = new Rectangle(0.0f, 0.0f, 15.0f, (full.height * 0.25f));
		left = new Rectangle(0.0f, (full.height * 0.25f), 7.5f, 14.0f);
		right = new Rectangle (7.5f, (full.height * 0.25f), 7.5f, 14.0f);
		top = new Rectangle(0.0f, (full.height * 0.25f), 15.0f, (full.height * 0.25f));
		
		this.setPosition(0, 0);
		
		velocityY = 0;
		
		dir = false;
		setSpeedPressed(false);
		fLives = 2;
		lives = fLives;
		coinsCollected = 0;
		score = 0;
		setFatigueLevel(0);
		setIntFatigue(0);
		starOn = false;
		spriteReload = false;
		isStanding = false;
		isDucking = false;
		starTime = 0;
		colorRotation = 0;
	}
	
	public int hits(Rectangle r){
		if(bottom.overlaps(r)){
			return 1;
		}
		if(top.overlaps(r)){
			return 4;
		}
		if(left.overlaps(r)){
			return 2;
		}
		if(right.overlaps(r)){
			return 3;
		}

		return -1;
	}
	
	public void action (int type, float x, float y){
		if (type == 1 || type == 4){
			velocityY = 0;
			setPosition(bottom.x, y);
		}
		if (type == 2 || type == 3){
			velocityY = 0;
			setPosition(x, bottom.y);
		}
	}
	
	public void update (float delta){
		velocityY -= (50 * delta);
		bottom.y += velocityY;
		top.y += velocityY;
		right.y += velocityY;
		left.y += velocityY;
		sprite.setPosition(bottom.x, bottom.y);
	}
	
	public void setPosition(float x, float y){
		full.x = x;
		full.y = y;
		
		bottom.x = x;
		bottom.y = y;
		
		left.x = x;
		left.y = (y + (full.height * 0.25f));
		
		right.x = (x + (full.width/2));
		right.y = (y + (full.height * 0.25f));
		
		top.x = x;
		top.y = (y + (full.height-(full.height * 0.25f)));
		
		sprite.setPosition(x, y);
	}
	
	public void moveLeft(float delta){
		if(isSpeedPressed()){
			bottom.x -=(fastWalkingPace * delta);
			sprite.setPosition(bottom.x, bottom.y);
		}else{
			bottom.x -=(normalWalkingPace * delta);
			sprite.setPosition(bottom.x, bottom.y);
		}
		if(!dir){
			dir = true;
			sprite.flip(true, false);
		}
	}
	
	public void moveRight(float delta){
		if(isSpeedPressed()){
			bottom.x +=(fastWalkingPace * delta);
			sprite.setPosition(bottom.x, bottom.y);
		}else{
			bottom.x +=(normalWalkingPace * delta);
			sprite.setPosition(bottom.x, bottom.y);
		}
		if(dir){
			dir = false;
			sprite.flip(true, false);
		}
	}
	
	public void jump(){
		if(velocityY == 0){
			velocityY = 12;	
		}
	}
	
	public void draw(SpriteBatch batch){
		if(starOn){
			if (starTime > starLength){
				starTime = 0;
				starOn = false;
			}else{
				starTime += Gdx.graphics.getDeltaTime() ;
			}
			switch(colorRotation){
				case 0:	
					sprite.setColor(Color.CYAN);
					colorRotation++;
					break;
				case 1:	
					sprite.setColor(Color.WHITE);
					colorRotation++;
					break;
				case 2:	
					sprite.setColor(Color.YELLOW);
					colorRotation++;
					break;
				case 3:	
					sprite.setColor(Color.GREEN);
					colorRotation++;
					break;
				case 4:	
					sprite.setColor(Color.ORANGE);
					colorRotation=0;
					break;
			}
			sprite.draw(batch);
		}else{
			if(spriteReload == true){
				spriteReload = false;
				if(isStanding){
					sprite.setTexture(TextureManager.mario_big_walking_1);
					
				}else{ //(if isDucking)
					sprite.setTexture(TextureManager.mario_duck);
				}
			}
			sprite.draw(batch);
		}
	}
	
	public Sprite getSprite(){
		return this.sprite;
	}

	@Override
	public TextureRegion currentFrame() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getHitBox() {
		// TODO Auto-generated method stub
		return full;
	}

	@Override
	public int hitAction(int side) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int getLives(){
		
		return lives;
	}
	
	public void setLives(int num){
		lives = num;
	}
	
	public void lostLife(){
		score -= 50;
		lives--;

	}
	
	public void gotCoin(){
		coinsCollected += 1;
		score += 100;
	}
	
	public void reset(){
		lives = fLives;
		coinsCollected = 0;
		score = 0;
		setFatigueLevel(0);
		setIntFatigue(0);
	}
	
	public void bulletWin(){
		score +=200;
	}
	
	public int getScore(){
		return score;
	}
	
	public void marioDuck(){

		sprite.setTexture(TextureManager.mario_duck);
		sprite.setSize(14, 18);
		
		full.set(sprite.getX(), sprite.getY(),sprite.getWidth(),sprite.getHeight());
		top.set(sprite.getX(), sprite.getY()+(full.height-(full.height * 0.25f)), sprite.getWidth(), (full.height * 0.25f));
		right.set(sprite.getX()+sprite.getWidth()/2,(sprite.getY()+(full.height * 0.25f)), sprite.getWidth()/2, (full.height - ((full.height * 0.25f)*2)));
		left.set(sprite.getX(), (sprite.getY()+(full.height * 0.25f)), sprite.getWidth()/2,  (full.height - ((full.height * 0.25f)*2)));
		bottom.set(sprite.getX(), sprite.getY(),sprite.getWidth(), (full.height * 0.25f));
		
		isStanding = false;
		isDucking = true;
		if(dir){
			sprite.flip(false, false);
		}

	}
	public void marioStand(){

		sprite.setTexture(TextureManager.mario_big_walking_1);
		sprite.setSize(15, 30);
		
		full = new Rectangle(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
		bottom = new Rectangle(sprite.getX(), sprite.getY(), sprite.getWidth(), (full.height * 0.25f));
		left = new Rectangle(sprite.getX(), (sprite.getY()+(full.height * 0.25f)), (sprite.getWidth() / 2), (full.height - ((full.height * 0.25f)*2)));
		right = new Rectangle ((sprite.getX() + (sprite.getWidth() / 2)), sprite.getY()+(full.height * 0.25f), (sprite.getWidth() / 2), (full.height - ((full.height * 0.25f)*2)));
		top = new Rectangle(sprite.getX(), sprite.getY()+(full.height-(full.height * 0.25f)), sprite.getWidth(), (full.height * 0.25f));
		
		isStanding = true;
		isDucking = false;
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
	
	public void gotStar(){
		starOn = true;
		spriteReload = true;
	}
	public Boolean getStar(){
		return starOn;
	}

	public int getIntFatigue() {
		return intFatigue;
	}

	public void setIntFatigue(int intFatigue) {
		this.intFatigue = intFatigue;
	}

	public float getFatigueLevel() {
		return fatigueLevel;
	}

	public void setFatigueLevel(float fatigueLevel) {
		this.fatigueLevel = fatigueLevel;
	}

	public boolean isSpeedPressed() {
		return speedPressed;
	}

	public void setSpeedPressed(boolean speedPressed) {
		this.speedPressed = speedPressed;
	}
	
}
