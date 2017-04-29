package cad.view;

import javax.swing.JPanel;

import cad.model.Model;

public class GameScreen extends JPanel{
	
	protected Model model;
	private ShipPlaceView board_player,board_ia;

	public GameScreen(Model model) {
		this.model = model;
		this.board_player = new ShipPlaceView(model);
		//this.board_ia = new Boardold();
		this.add(board_player);
		//this.add(board_ia);

	}

}
