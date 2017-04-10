package fr.ul.cad;

import com.badlogic.gdx.*;
import fr.ul.cad.controller.*;
import fr.ul.cad.view.*;

public class BatailleNavale extends Game {
	private MenuScreen menuScreen;
	private GameScreen gameScreen;
	private EndScreen endScreen;


	@Override
	public void create() {
		this.gameScreen = new GameScreen(this);
		this.menuScreen = new MenuScreen(this);
		this.endScreen = new EndScreen(this);
		this.setMenuScreen();
		
	}

	// permet de passer a la fenetre de jeux
	public void setGameScreen() {
		setScreen(gameScreen);
	}

	// permet de passer a la fenetre de menu
	public void setMenuScreen() {
		setScreen(menuScreen);
	}

	// permet de passer a la fenetre de fin
	public void setEndScreen() {
		setScreen(endScreen);
	}

}
