package fr.ul.cad.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import fr.ul.cad.BattleShip;

public class ChoiceRenderer extends ScreenAdapter {
	private BattleShip mygame;
	private Stage stage;
	private Skin skin;

	public ChoiceRenderer(BattleShip battleShip) {
		 this.mygame = battleShip; 
		 this.stage = new Stage();
		 Gdx.input.setInputProcessor(stage); 
		 skin = new Skin(Gdx.files.internal("skin/glassy-ui.json")); 
		 createChoice();
		
	}

	private void createChoice() {
		Table table = new Table();
		table.setSize(680, 480);
		
		Label tirJoueur = new Label("Strategie tir Joueur ",skin);
		table.add(tirJoueur);
		String[] items = {"Basic","A partir des bateaux"};    
	    SelectBox choixJoueur = new SelectBox(skin);
	    choixJoueur.setItems(items);
	    table.add(choixJoueur).width(200);
		table.row();

		Label tirIa = new Label("Strategie tir IA",skin);
		table.add(tirIa);
		String[] items2 = {"Alea","Diagonale","Complex"};  //strategy a recuperer automatiquement plus tard  
	    SelectBox choixIa = new SelectBox(skin);
	    choixIa.setItems(items2);
	    table.add(choixIa).width(200);
		table.row();
		
		Label epoque = new Label("Epoque",skin);
		table.add(epoque);
		String[] items3 = {"Moderne","Pirate","Romaine"};  //epoque a recuperer automatiquement plus tard  
	    SelectBox choixEpoque = new SelectBox(skin);
	    choixEpoque.setItems(items3);
	    table.add(choixEpoque).width(200);
		table.row();
		
		TextButton play = new TextButton("Jouer", skin,"small");
		play.addListener(new ClickListener(){
			private BattleShip battleship = mygame;

			@Override
	           public void clicked(InputEvent event, float x, float y) {
	        	   this.battleship.setGameScreen();
	           }
	      });
		table.add(play);
		table.row();

		stage.addActor(table);
	}

	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl20.glViewport(0, 0, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}

	// liberation
	public void dispose() {
		stage.dispose();
	}
}
