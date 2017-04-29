package cad.model;

import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable implements Runnable {
	
	public static int WIDTH = 10;
	public static int HEIGHT = 10;
	
	private ArrayList<Age> ages;
	private Board boardPlayer;
	private Board boardAi;
	public int x = 0, y = 0;
	
	public Model(){
		Age moderne = new Age("Moderne");
		moderne.addShip(new Ship("s4","",4,4),1);
		moderne.addShip(new Ship("s3","",3,3),2);
		moderne.addShip(new Ship("s2","",2,2),3);
		moderne.addShip(new Ship("s1","",1,1),4);
		
		boardAi = new Board();
		boardAi.addShip(moderne.getShips().get(0), 1, 1);
		boardAi.addShip(moderne.getShips().get(1), 3, 1);
		boardAi.addShip(moderne.getShips().get(2), 3, 5);
		boardAi.addShip(moderne.getShips().get(3), 5, 1);
		boardAi.addShip(moderne.getShips().get(4), 5, 4);
		boardAi.addShip(moderne.getShips().get(5), 5, 7);
		boardAi.addShip(moderne.getShips().get(6), 7, 1);
		boardAi.addShip(moderne.getShips().get(7), 7, 3);
		boardAi.addShip(moderne.getShips().get(8), 7, 5);
		boardAi.addShip(moderne.getShips().get(9), 7, 7);
	}
	
	public synchronized void moveShip(int x, int y){
		this.mettreAjour();
	}
	
	public void lancerModelisation(){
		Thread t = new Thread((Runnable) this, "Modelisation");
		t.start();
	}

	@Override
	public void run() {
		this.mettreAjour();
	}
	
	public void mettreAjour(){
		setChanged();
		notifyObservers();
	}


}
