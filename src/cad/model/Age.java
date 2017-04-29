package cad.model;

import java.util.ArrayList;

public class Age {

	private String age;
	private ArrayList<Ship> ships;
	
	public Age(String age){
		this.age = age;
		this.ships = new ArrayList<Ship>();
	}
	

	/***********************************************************/
	/********************* GETTER / SETTER *********************/
	/***********************************************************/
	
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public ArrayList<Ship> getShips() {
		return ships;
	}

	public void setShips(ArrayList<Ship> ships) {
		this.ships = ships;
	}
	
	
	/***********************************************************/
	/************************* FONCTION ************************/
	/***********************************************************/
	
	public void addShip(Ship ship, int type){
		for(int i=0; i<type; i++)
			this.ships.add(ship);
	}
	
	public void deleteShip(Ship ship){
		this.ships.remove(ship);
	}
	
}
