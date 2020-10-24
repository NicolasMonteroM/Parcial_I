package model;

import java.util.LinkedList;

public class DogList {

	private LinkedList<Dog> peluditos;
	
	public DogList() {
		
		peluditos = new LinkedList<Dog>();
	}

	public void addPeludito(Dog d) {
		peluditos.add(d);

	}

	public LinkedList<Dog> getLista() {
		return peluditos;

	}

}
