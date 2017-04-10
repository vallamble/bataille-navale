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
		this.gameScreen = new WorldRenderer(this);
		this.menuScreen = new MenuRenderer(this);
		this.endScreen = new EndRenderer(this);
		this.choicescreen = new ChoiceRenderer(this);
		this.setMenuScreen();

	}

	// permet de passer a la fenetre de jeux
	public void setGameScreen() {
		setScreen(gameScreen);
	}

	// permet de passer a la fenetre du choix des strategies
	public void setChoiceScreen() {
		setScreen(choicescreen);
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
