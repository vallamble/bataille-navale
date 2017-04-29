package cad.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import cad.model.Model;
import cad.model.Ship;

public class ShipPlaceView extends JPanel implements Observer{
	
	private static final long serialVersionUID = 1L;
	private Model model;
	private JButton[][] board;
	private JButton[] ships;
	private JPanel panelBoard, panelShips;
	//private boolean vertical = false;

	public ShipPlaceView(Model modele){
		super();
		this.model = modele;
		
		this.board = new JButton[11][11];
		this.drawBoard(this.panelBoard, this.board, 50, 50);
		
		this.ships = new JButton[10];
		this.drawShips(this.panelShips, this.ships, 50, 50);

		this.model.addObserver(this);
	}
	
	private JPanel drawJPanel(int x, int y, int w, int h){
		JPanel panel = new JPanel();
		panel.setBackground(Color.red);
		panel.setBounds(x,y, w, h);
		this.add(panel);
		return panel;
	}
	
	
	/***********************************************************/
	/************************** Board **************************/
	/***********************************************************/
	
	// build board game 
	private void drawBoard(JPanel jp, JButton[][] board, int x, int y){
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
					}
				}
				board[i][j].setPreferredSize(new Dimension(50,50));
				board[i][j].setOpaque(false);
				this.addJButtonListener(board[i][j]);
				
				jp.add(board[i][j]);
			}
		}
	}
	
	private void addJButtonListener(JButton button){
		button.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {
				JButton source = (JButton)e.getSource();
				source.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				viewShipBoard();
			}
			public void mouseExited(MouseEvent e) {
				JButton source = (JButton)e.getSource();
				source.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
	}
	
	private void viewShipBoard(){
	}
	
	
	/***********************************************************/
	/************************** Ships **************************/
	/***********************************************************/
	
	private void drawShips(JPanel jp, JButton[] label, int x, int y){
		jp = this.drawJPanel(x, y, 450, 800);
		jp.setLayout(new GridLayout(4,4,20,50));
		for(int i=0; i<10; i++)
			label[i] = new JButton();
		// initial ship position
		int i=0;
		for(Ship ship: this.model.getAge().getShips()){
			this.iconShip(jp, ship, ship.getLengthShip()*50, label[i]);
			i++;
		}
	}
	
	private void iconShip(JPanel jp, final Ship ship, int width, JButton jb){
		ImageIcon icon = new ImageIcon(new ImageIcon(ship.getPathImage()).getImage().getScaledInstance(width, 40, Image.SCALE_DEFAULT));
		jb.setIcon(icon);
		jb.setBorderPainted(false);
		jb.setFocusPainted(false);
		jb.setContentAreaFilled(false);
		jb.setOpaque(false);
		jb.setPreferredSize(new Dimension(width,40));
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setChooseAge(ship);
			}
		});
		jp.add(jb); 
	}
		
	@Override
	public void update(Observable arg0, Object arg1) {
	}
	
}