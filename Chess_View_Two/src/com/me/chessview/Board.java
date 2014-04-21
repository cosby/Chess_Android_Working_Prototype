package com.me.chessview;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Vector2;


public class Board {
	/** 
	 * @author Patrick
	 * 
	 * The tiles making up the board **/

	Tile[][] tiles = new Tile[8][8];



	public Tile[][] getTiles() {
		return tiles;

	}


	public Board() {

		createBoard();
	}

	private void createBoard() {

		FileHandle b = Gdx.files.internal("data/blacktile.png");
		FileHandle w = Gdx.files.internal("data/whitetile.png");

		float xMod = (Gdx.graphics.getWidth()/8);;
		float yMod = (Gdx.graphics.getWidth()/8);
		
		for (int i = 0 ; i < 8 ; i++){			
			for (int j = 0 ; j < 8 ; j++){

				if((i+1) % 2 != 0 && (j+1) % 2 != 0){
				tiles[i][j] = new Tile(new Vector2(xMod * i, 
						yMod * j), b);
				
				}else if((i+1) % 2 == 0 && (j+1) % 2 != 0){ 
					tiles[i][j] = new Tile(new Vector2(xMod * i,
							yMod * j), w);
					
				}
				
				if((i+1) % 2 != 0 && (j+1) % 2 == 0){
					tiles[i][j] = new Tile(new Vector2(xMod * i,
							yMod * j), w);
					
				}else if((i+1) % 2 == 0 && (j+1) % 2 == 0){ 
					tiles[i][j] = new Tile(new Vector2(xMod * i,
							yMod * j), b);
					
				}
			}
		}
	}

}

