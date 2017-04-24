package cad.view;

import java.awt.Color;

import javax.swing.JPanel;

import cad.BattleShip;

public class GameScreen extends JPanel{

	public GameScreen(BattleShip battleShip) {
		this.setBackground(Color.BLUE);      
	    battleShip.setContentPane(this); 
	}

}
