package com.me.chessview;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
/**
 * 
 * @author Patrick
 * 
 * Our piece object. We will strip this down of dead code in the final version.
 */
public class Piece {

	private Vector2 position;
	private int team;
	private Texture image;
	private boolean myTurn;
	private boolean alive = true;
	private boolean moved = false;
	private int[] positions;
	
	public Piece(float startX, float startY){
		
		position = new Vector2(startX, startY);
		
	}
	
	public Vector2 getPosition() {
		return position;
	}
	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Texture getImage() {
		return image;
	}
	public void setImageId(FileHandle imageId) {
		image = new Texture(imageId);
		
	}
	public int getTeam() {
		return team;
	}
	public void setTeam(int team) {
		this.team = team;
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public boolean isMoved() {
		return moved;
	}
	public void setMoved(boolean moved) {
		this.moved = moved;
	}
	public boolean isMyTurn() {
		return myTurn;
	}
	public void setMyTurn(boolean myTurn) {
		this.myTurn = myTurn;
	}
	public int[] getPositions() {
		return positions;
	}
	public void setPositions(int[] positions) {
		this.positions = positions;
	}
	
}
