package fr.ul.cad.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

import fr.ul.cad.BattleShip;

/**
 * Created by val on 06/04/2017.
 */

public class WorldRenderer extends ScreenAdapter {

	private BattleShip mygame;

	public WorldRenderer(BattleShip battleShip) {
		 this.mygame = battleShip; 
	}
	
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl20.glViewport(0, 0, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}

}
