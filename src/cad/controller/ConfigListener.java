package cad.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cad.BattleShip;
import cad.view.ConfigScreen;

public class ConfigListener implements ActionListener {
	private ConfigScreen cScreen;
	private BattleShip bs;

	public ConfigListener(BattleShip bs, Object selectedItem, Object selectedItem2, Object selectedItem3, ConfigScreen configScreen) {
		this.cScreen = configScreen;
		this.bs = bs;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cScreen.setVisible(false);
		bs.setGameScreen();
	}

}
