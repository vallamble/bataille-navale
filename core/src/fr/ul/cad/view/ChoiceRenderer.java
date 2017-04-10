package fr.ul.cad.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

import fr.ul.cad.BattleShip;

public class ChoiceRenderer extends ScreenAdapter {

	public ChoiceRenderer(BattleShip battleShip) {
		// TODO Auto-generated constructor stub
	}

	
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 0);
		Gdx.gl20.glViewport(0, 0, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	
	}
}
