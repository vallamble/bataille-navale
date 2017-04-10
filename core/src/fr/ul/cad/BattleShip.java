package fr.ul.cad;

import com.badlogic.gdx.*;

import fr.ul.cad.view.*;

public class BattleShip extends Game {
	private MenuRenderer menuScreen;
	private WorldRenderer gameScreen;
	private EndRenderer endScreen;
	private ChoiceRenderer choicescreen;

	@Override
	public void create() {
		this.setMenuScreen();

	}

	// permet de passer a la fenetre de jeux
	public void setGameScreen() {
		this.gameScreen = new WorldRenderer(this);
		setScreen(gameScreen);
	}

	// permet de passer a la fenetre du choix des strategies
	public void setChoiceScreen() {
		this.choicescreen = new ChoiceRenderer(this);
		setScreen(choicescreen);
	}

	// permet de passer a la fenetre de menu
	public void setMenuScreen() {
		this.menuScreen = new MenuRenderer(this);
		setScreen(menuScreen);
	}

	// permet de passer a la fenetre de fin
	public void setEndScreen() {
		this.endScreen = new EndRenderer(this);
		setScreen(endScreen);
	}

}
