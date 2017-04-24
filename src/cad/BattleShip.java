package cad;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import cad.view.ConfigScreen;
import cad.view.GameScreen;
import cad.view.MenuScreen;

public class BattleShip extends JFrame {

	private MenuScreen menu;
	private GameScreen game;
	private ConfigScreen config;
	private JFrame frame;

	public BattleShip() {
		frame = new JFrame("Bataille navale");
		this.menu = new MenuScreen(this);
		frame.add(menu, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void setGameScreen() {
		this.game = new GameScreen(this);
		frame.add(game, BorderLayout.CENTER);
	}
	
	public void setConfigScreen() {
		this.config = new ConfigScreen(this);
		frame.add(config, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new BattleShip();
	}
}