package com.me.chessview;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
/** @author Patrick
 * 
 *  Creates and holds a list of piece objects*/


public class PieceController {

	public ArrayList<Piece> pieces = new ArrayList<Piece>();

	private FileHandle[] img = {Gdx.files.internal("data/whiterook.png"),Gdx.files.internal("data/whitebishop.png"),
			Gdx.files.internal("data/whiteknight.png"), Gdx.files.internal("data/whitequeen.png"),
			Gdx.files.internal("data/whiteking.png"), Gdx.files.internal("data/whitepawn.png"),
			Gdx.files.internal("data/blackrook.png"),Gdx.files.internal("data/blackbishop.png"),
			Gdx.files.internal("data/blackknight.png"), Gdx.files.internal("data/blackqueen.png"),
			Gdx.files.internal("data/blackking.png"), Gdx.files.internal("data/blackpawn.png")};
	
	public PieceController(){
		populateBoard();
		initialisePieces();

	}

	public void populateBoard(){
		/*
		 * The following function populates the board with
		 * generic 'pieces', they are given only team and x,y positions
		 * the i for loop is for populating both 'sides' pieces
		 * the y loop is for y co-ordinates
		 * the x loop is for x co-ordinates
		 */
		float size = (Gdx.graphics.getWidth()/8);
		Piece piece;
		
		float x = 1;
		int team = 0;

		for(float y = 0 ; y < 2 ; y++){
			for(x = 0 ; x < 8 ; x++){
				piece = new Piece(x * size, y * size);
				piece.setTeam(team);
				pieces.add(piece);
			}

		}

		x = 1;			//reset co-ordinates for far side of board
		team = 1;		//second iteration, so we are populating the black pieces
		
		for(float y = 7 ; y > 5 ; y--){
			for(x = 0 ; x < 8 ; x++){
				piece = new Piece(x * size, y * size);
				piece.setTeam(team);
				pieces.add(piece);
			}

		}

	}

	public void initialisePieces(){

		int j = 0;
		/*
		 * The following code  iterates through the objects list and
		 * assigns them with the correct image from the image bank
		 */
		for(int i = 0 ; i < 16 ; i++){
			pieces.get(i).setImageId(img[j]);

			if(i < 4) j++;
			if(i == 4) j = 3;
			if(i >= 4 && i < 7) j--;			
			if(i >= 7 && i < 16) j = 5;
		}
		
		j = 6;
		
		for(int i = 16 ; i < 32 ; i++){
			
			pieces.get(i).setImageId(img[j]);
			
			if(i < 20) j++;
			if(i == 20) j = 8;
			if(i > 20 && i < 23) j--;
			if(i >= 23 && i < 32) j = 11;

		}

	}

}