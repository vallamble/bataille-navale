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

public class ShipPlaceView extends JPanel implements Observer{
	
	private Model model;
	private JButton[][] board;
	private JButton[] ships;
	private JPanel panelBoard, panelShips;

	public ShipPlaceView(Model modele){
		super();
		this.model = modele;
		
		this.board = new JButton[11][11];
		this.drawBoard(this.panelBoard, this.board, 50, 50);
		
		this.ships = new JButton[10];
		this.drawShips(this.panelShips, this.ships, 50, 50);
		
		/*panelShips.addMouseMotionListener(new MouseAdapter() {
	        public void mouseDragged(MouseEvent e) {
	        	if((e.getX() >= l4.getLocation().x && e.getX() <= l4.getLocation().x+l4.getWidth()) &&
	        	   (e.getY() >= l4.getLocation().y && e.getY() <= l4.getLocation().y+l4.getHeight()))
	        	jLabel[0].setBounds(e.getX()-80,e.getY()-20, jLabel[0].getWidth(), jLabel[0].getHeight());
	        }
	    });*/

		this.model.addObserver(this);
	}
	
	private JPanel drawJPanel(int x, int y, int w, int h){
		JPanel panel = new JPanel();
		panel.setBackground(Color.red);
		panel.setBounds(x,y, w, h);
		this.add(panel);
		return panel;
	}
	
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
			}
			public void mouseExited(MouseEvent e) {
				JButton source = (JButton)e.getSource();
				source.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
	}
	
	private void drawShips(JPanel jp, JButton[] label, int x, int y){
		jp = this.drawJPanel(x, y, 450, 800);
		jp.setLayout(new GridLayout(4,4,20,50));
		for(int i=0; i<10; i++)
			label[i] = new JButton();
		
		// initial ship position
		this.iconShip(jp, "images/s1.png", 200, label[0], 633, 132);
		this.iconShip(jp, "images/s1.png", 150, label[1], 150, 50);
		this.iconShip(jp, "images/s1.png", 150, label[2], 150, 250);
		this.iconShip(jp, "images/s1.png", 100, label[3], 250, 50);
		this.iconShip(jp, "images/s1.png", 100, label[4], 250, 200);
		this.iconShip(jp, "images/s1.png", 100, label[5], 250, 350);
		this.iconShip(jp, "images/s1.png", 50, label[6], 350, 50);
		this.iconShip(jp, "images/s1.png", 50, label[7], 350, 150);
		this.iconShip(jp, "images/s1.png", 50, label[8], 350, 250);
		this.iconShip(jp, "images/s1.png", 50, label[9], 350, 350);
	}
	
	private void iconShip(JPanel jp, String irl, int width, JButton jb, int x, int y){
		ImageIcon icon = new ImageIcon(new ImageIcon(irl).getImage().getScaledInstance(width, 40, Image.SCALE_DEFAULT));
		jb.setIcon(icon);
		jb.setBorderPainted(false);
		jb.setFocusPainted(false);
		jb.setContentAreaFilled(false);
		jb.setOpaque(false);
		jb.setPreferredSize(new Dimension(width,40));
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		jp.add(jb); 
	}
		
	@Override
	public void update(Observable arg0, Object arg1) {
	}
	
}