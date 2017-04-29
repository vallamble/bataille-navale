package cad.model;

import java.awt.Point;
import java.util.HashMap;
import java.util.Observable;

public class Model extends Observable implements Runnable {
	
	public static int WIDTH = 10;
	public static int HEIGHT = 10;
	
	private HashMap<Integer, Age> ages;
	private int keyage = 0;
	private Cell[][] boardPlayer, boardAi;
	private Point selectShipPLace = null;
	private Ship chooseShip;
	
	
	public Model(){
		ages = new HashMap<Integer, Age>();
		String[] shipInfo = new String[8];
		for(int i=0; i<8;i=i+2){
			shipInfo[i] = "s"+i;
			shipInfo[i+1] = "assert/s1.png";
		}
		this.buildAge("Moderne", shipInfo);
		
		this.boardPlayer = new Cell[WIDTH+1][HEIGHT+1];
		this.buildBoards(this.boardPlayer);
		this.boardAi = new Cell[WIDTH+1][HEIGHT+1];
		this.buildBoards(this.boardAi);
		
		this.exemplePlace(this.boardPlayer);
		this.print();
	}
	
	private void buildAge(String nameAge, String[] shipInfo){ // ship = name - irl
		this.keyage++;
		Age age = new Age("nameAge");
		age.addShip(new Ship(shipInfo[0],shipInfo[1],4,4),1);
		age.addShip(new Ship(shipInfo[2],shipInfo[3],3,3),2);
		age.addShip(new Ship(shipInfo[4],shipInfo[5],2,2),3);
		age.addShip(new Ship(shipInfo[6],shipInfo[7],1,1),4);
		this.ages.put(this.keyage, age);
	}
	
	private void buildBoards(Cell[][] board){
		
		for(int i=1; i<WIDTH+1; i++){
			for(int j=1; j<HEIGHT+1; j++){
				board[i][j] = new Cell(i, j, null);
			}
		}
	}
	
	private void exemplePlace(Cell[][] board){
		int position[][] = {{2,2}, {4,2}, {4,6}, {6,2}, {6,5}, {6,8}, {8,2}, {8,4}, {8,6}, {8,8}};
		int i = 0;
		for(Ship ship : this.ages.get(this.keyage).getShips()){
			for(int j=0; j<ship.getLengthShip(); j++){
				this.setShipCell(board, position[i][0], position[i][1]+j, this.ages.get(this.keyage).getShips().get(i));
			}
			i++;
		}
	}
	
	private void print(){
		for(int i=1; i<WIDTH+1; i++){
			System.out.println("---------------------");
			for(int j=1; j<HEIGHT+1; j++){
				if(this.boardPlayer[i][j].getShip() != null)
					System.out.print("|X");
				else
					System.out.print("| ");
			}
			System.out.print("|\n");
		}
		System.out.println("---------------------");
	}
	
	
	/***********************************************************/
	/********************* GETTER / SETTER *********************/
	/***********************************************************/
	
	public HashMap<Integer, Age> getAges() {
		return ages;
	}

	public void setAges(HashMap<Integer, Age> ages) {
		this.ages = ages;
	}
	
	public int getKeyage() {
		return keyage;
	}

	public void setKeyage(int keyage) {
		this.keyage = keyage;
	}

	public Point getSelectShipPLace() {
		return selectShipPLace;
	}

	public void setSelectShipPLace(Point selectShipPLace) {
		this.selectShipPLace = selectShipPLace;
	}
	
	public Ship getChooseShip() {
		return chooseShip;
	}

	public void setChooseAge(Ship ship) {
		this.chooseShip = ship;
	}

	public Cell[][] getBoardPlayer() {
		return boardPlayer;
	}

	public void setBoardPlayer(Cell[][] boardPlayer) {
		this.boardPlayer = boardPlayer;
	}

	public Cell[][] getBoardAi() {
		return boardAi;
	}

	public void setBoardAi(Cell[][] boardAi) {
		this.boardAi = boardAi;
	}

	/***********************************************************/
	/********************** ShipPLcaeView **********************/
	/***********************************************************/

	public synchronized void setShipCell(Cell[][] cells, int x, int y, Ship ship){
		cells[x][y].setShip(ship);
		this.mettreAjour();
	}
	
	public synchronized void moveShip(int x, int y){
		this.mettreAjour();
	}

	
	/***********************************************************/
	/************************ GameScreen ***********************/
	/***********************************************************/
	
	

	@Override
	public void run() {
		this.mettreAjour();
	}
	
	public void mettreAjour(){
		setChanged();
		notifyObservers();
	}


}
