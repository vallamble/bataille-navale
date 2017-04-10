package fr.ul.cad.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import fr.ul.cad.BattleShip;

public class MenuRenderer extends ScreenAdapter {
	private BattleShip mygame;
	private Stage stage;
	private Skin skin;

	// creation de la premiere page
	public MenuRenderer(BattleShip mygame) {
		this.mygame = mygame;
		this.stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
		createMenu();
	}

	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl20.glViewport(0, 0, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}

	private void createMenu() {
		Table table = new Table();
		table.setSize(680, 480);

		TextButton startGame = new TextButton("Start Game", skin);
		startGame.addListener(new ClickListener(){
			private BattleShip battleship = mygame;

			@Override
	           public void clicked(InputEvent event, float x, float y) {
	        	   this.battleship.setChoiceScreen();
	           }
	      });
		table.add(startGame);
		table.row();

		TextButton load = new TextButton("Load", skin);
		table.add(load).padTop(15).padBottom(15);
		table.row();

		TextButton exit = new TextButton("Exit", skin);
		exit.addListener(new ClickListener(){
	           @Override
	           public void clicked(InputEvent event, float x, float y) {
	               Gdx.app.exit();
	           }
	      });
	    table.add(exit);
		table.row();
		stage.addActor(table);
		

	}

	// liberation
	public void dispose() {
		stage.dispose();
	}

}
