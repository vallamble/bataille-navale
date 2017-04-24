package cad.view;

import java.awt.Color;
import java.awt.Label;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import cad.BattleShip;
import cad.controller.ConfigListener;

public class ConfigScreen extends JPanel {
	private Object[] liste1,liste2,liste3;
	private JComboBox tirJoueur,tirOrdinateur,epoque;
	private Label tirJ,tirIa,eq;
	private JButton play;
	private BattleShip bs;



	public ConfigScreen(BattleShip battleShip) {
		this.bs = battleShip;
		this.liste1 = new Object[]{"Basique","Bateau"};
		this.tirJoueur = new JComboBox(liste1);
		this.liste2 = new Object[]{"Alea","Diagonale","Complex"};// a recup auto plus tard
		this.tirOrdinateur = new JComboBox(liste2);
		this.liste3 = new Object[]{"Moderne","Pirate","Romaine"}; // pareille
		this.epoque = new JComboBox(liste3);
		this.tirJ = new Label("Strategie tir Joueur ");
		this.tirIa = new Label("Strategie tir IA");
		this.eq = new Label("Epoque");
		this.play = new JButton("Play");
		drawConfig();
		controller();
	}


	private void controller() {
		play.addActionListener(new ConfigListener(bs,tirJoueur.getSelectedItem(),tirOrdinateur.getSelectedItem(),epoque.getSelectedItem(),this));
	}


	private void drawConfig() {
		this.setBackground(Color.GREEN);
		Box panneauBouton = Box.createVerticalBox();
		panneauBouton.add(tirJ);
		panneauBouton.add(tirJoueur);
		panneauBouton.add(tirIa);
		panneauBouton.add(tirOrdinateur);
		panneauBouton.add(eq);
		panneauBouton.add(epoque);
	    panneauBouton.add(Box.createVerticalStrut(60));
	    panneauBouton.add(play);
		this.add(panneauBouton);		
	}

}
