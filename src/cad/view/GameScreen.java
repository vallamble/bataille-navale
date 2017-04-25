package cad.view;

import javax.swing.JPanel;
import cad.BattleShip;
import cad.model.Board;

public class GameScreen extends JPanel{
	private Board board_player,board_ia;



	public GameScreen(BattleShip battleShip) {

		this.board_player = new Board();
		this.board_ia = new Board();
		this.add(board_player);
		this.add(board_ia);

	}

}
