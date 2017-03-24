package fr.ul.cad;

import com.badlogic.gdx.*;
import fr.ul.cad.controller.*;
import fr.ul.cad.view.*;

public class BatailleNavale extends Game {
	private MenuScreen menuScreen;
	private GameScreen gameScreen;
	private EndScreen endScreen;
	private MenuListener menuListener;
	private GameListener gameListener;
	private EndListener endListener;

	@Override
	public void create() {
		this.gameScreen = new GameScreen(this);
		this.gameListener = new GameListener(gameScreen);
		this.menuScreen = new MenuScreen(this);
		this.menuListener = new MenuListener(menuScreen);
		this.endScreen = new EndScreen(this);
		this.endListener = new EndListener(endScreen);
		this.setMenuScreen();
		
	}

	// permet de passer a la fenetre de jeux
	public void setGameScreen() {
		Gdx.input.setInputProcessor(gameListener);
		setScreen(gameScreen);
	}

	// permet de passer a la fenetre de menu
	public void setMenuScreen() {
		Gdx.input.setInputProcessor(menuListener);
		setScreen(menuScreen);
	}

	// permet de passer a la fenetre de fin
	public void setEndScreen() {
		Gdx.input.setInputProcessor(endListener);
		setScreen(endScreen);
	}

}
