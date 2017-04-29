package cad.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import cad.model.Model;

public class GameScreen extends JPanel implements Observer{

	private static final long serialVersionUID = 1L;
	protected Model model;
	private JButton[][] boardPlayer, boardAI;
	private JPanel panelBoardPlayer, panelBoardAI;

	public GameScreen(Model model) {
		this.model = model;
		/* 
		 * placement des ship partie Nihad 
		 * this.board_player = new ShipPlaceView(model);
		 */
		
		this.boardPlayer = new JButton[11][11];
		this.drawBoard(this.panelBoardPlayer, this.boardPlayer, 50, 50, true);
		
		this.boardAI = new JButton[11][11];
		this.drawBoard(this.panelBoardAI, this.boardAI, 50, 50, false);
		
		this.model.addObserver(this);
	}
	
	
	private JPanel drawJPanel(int x, int y, int w, int h){
		JPanel panel = new JPanel();
		panel.setBounds(x,y, w, h);
		this.add(panel);
		return panel;
	}
	
	
	/***********************************************************/
	/************************** Board **************************/
	/***********************************************************/
	
	// build board game 
	private void drawBoard(JPanel jp, JButton[][] board, int x, int y, boolean player){
		jp = this.drawJPanel(x, y, 450, 450);
		char c = 'A';
		jp.setLayout(new GridLayout(10 + 1,10 + 1,1,1));
		for(int i = 0;i <= 10;i++){
			for(int j = 0;j <= 10;j++){
				if(i == 0){
					if(j != 0)
						board[i][j] = new JButton("" + j);
					else	
						board[i][j] = new JButton();
					board[i][j].setEnabled(false);
				}else{
					if(j == 0){
						board[i][j] = new JButton("" + c);
						c += 1;						
						board[i][j].setEnabled(false);
					}else{
						board[i][j] = new JButton();
						board[i][j].setEnabled(!player);
					}
				}
				board[i][j].setPreferredSize(new Dimension(50,50));
				if(player && i < 10 && j < 10 && i > 0 && j > 0 && model.getBoardPlayer()[i][j].getShip() != null)
					board[i][j].setBackground(Color.blue.darker());
				
				board[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				
				jp.add(board[i][j]);
			}
		}
	}


	@Override
	public void update(Observable arg0, Object arg1) {
	}

}
