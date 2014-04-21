package com.me.chessview;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
/**
 * 
 * @author Patrick
 * 
 * Our tile object.
 * We will strip this down in the final version and cut dead code.
 *
 */
public class Tile {

	static final float SIZE = 1f;

	Vector2 position = new Vector2();
	Texture texture;

	public Tile(Vector2 pos, FileHandle img) {

		this.position = pos;
		texture = new Texture(img);
	}


	public Vector2 getPosition() {
		
		return position;
	}

}
