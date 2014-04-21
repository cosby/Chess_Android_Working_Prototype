package com.me.chessview;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
/**
 * 
 * @author Patrick
 * Main Game environment, we will call this as an activity when
 * we glue this with the android prototype. Handles all the GUI and I/O.
 * 
 * The libgdx library apparently breaks up the I/O and main thread automatically
 * however we will have to ensure this is true when testing memory usage.
 */
public class ChessView implements ApplicationListener, InputProcessor {


	private SpriteBatch batch;
	private PieceController p;
	private Board b;
	private float size;
	@Override
	public void create() {
		//board = new BoardRender(); TODO: DELETE LATER IF NOT NEEDED
		b = new Board();
		p = new PieceController();
		//piece = new PieceRender(); TODO: DELETE LATER IF NOT NEEDED
		size = (Gdx.graphics.getWidth()/8);
		Gdx.input.setInputProcessor(this);

	}

	@Override
	public void dispose() {
		batch.dispose();

	}

	@Override
	public void render() {	

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Texture tx;
		batch = new SpriteBatch();			


		batch.begin();
		for(int i = 0 ; i < 8 ; i++){
			for(int j = 0 ; j < 8 ; j++){
				tx = (b.tiles[i][j].texture);
				batch.draw(tx, b.tiles[i][j].getPosition().x,
						b.tiles[i][j].getPosition().y, size, size);

			}
		}


		for(int i = 0 ; i < 32 ; i++){

			tx = p.pieces.get(i).getImage();
			batch.draw(tx, p.pieces.get(i).getPosition().x,
					p.pieces.get(i).getPosition().y, size, size);

		}

		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	float x = 0;
	float y = 0;

	int index;
	boolean selected = false;
	

	/*
	 * touchDown cycles through the entire list of pieces and grabs the
	 * index of the piece where the touch/click occured.
	 *
	 * It then sets the 'selected' flag to be true and, using index,
	 * assigns the piece with a new vector by comparing all of the tiles
	 * to the x,y positions and finding the nearest match, it then uses
	 * the x,y position of the nearest match as the new vector for the piece
	 * 
	 */
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		//grabs the index of the piece where the touch happened
		if(selected != true){
			for(int i = 0 ; i < p.pieces.size() ; i++){
				if(Gdx.input.getX(pointer) > (p.pieces.get(i).getPosition().x) &&
						Gdx.input.getX(pointer) < (p.pieces.get(i).getPosition().x) + size &&			
						Gdx.graphics.getHeight() - Gdx.input.getY(pointer) > p.pieces.get(i).getPosition().y &&
						Gdx.graphics.getHeight() - Gdx.input.getY(pointer) < p.pieces.get(i).getPosition().y + size)
				{

					index = i;					
					selected = true;


				}
			}
		}else if(selected == true){
			for(int i = 0 ; i < 8 ; i++){
				for(int j = 0 ; j < 8 ; j++){
					//the following if statement will lock the piece into the closest matching tile
					if(Gdx.input.getX(pointer) > b.tiles[i][j].getPosition().x &&
							Gdx.input.getX(pointer) < b.tiles[i][j].getPosition().x + size &&			
							Gdx.graphics.getHeight() - Gdx.input.getY(pointer) > b.tiles[i][j].getPosition().y &&
							Gdx.graphics.getHeight() - Gdx.input.getY(pointer) < b.tiles[i][j].getPosition().y + size)
					{
						x = b.tiles[i][j].getPosition().x;
						y = b.tiles[i][j].getPosition().y;

						p.pieces.get(index).setPosition(new Vector2(x,y));
						selected = false;
					}
				}
			}
		}

		return true;
	}


	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {		

		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
