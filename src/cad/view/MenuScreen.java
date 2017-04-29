package cad.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import cad.BattleShip;

public class MenuScreen extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private BattleShip bs;
	private JButton play,load,exit;

	public MenuScreen(BattleShip battleShip) {
		this.bs = battleShip;
		drawMenu();
		controller();
	}

	private void controller() {
		play.addActionListener(new ActionListener(){  	
	        public void actionPerformed(ActionEvent event){
	        	setVisible(false);
	        	bs.setConfigScreen();}});
		 
		exit.addActionListener(new ActionListener(){  	
	        public void actionPerformed(ActionEvent event){
	        	System.exit(0);}});		
	}

	private void drawMenu() {
		this.play = new JButton("Play");
		this.load = new JButton("Load");
		this.exit = new JButton("Exit");
		this.setBackground(Color.BLUE);
		Box panneauBouton = Box.createVerticalBox();
		panneauBouton.add(play);
	    panneauBouton.add(Box.createVerticalStrut(20));
		panneauBouton.add(load);
	    panneauBouton.add(Box.createVerticalStrut(20));
		panneauBouton.add(exit);
		this.add(panneauBouton);
	}
	
	
}
