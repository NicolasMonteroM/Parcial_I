package model;

import java.util.Comparator;

public class CompareBreed implements Comparator<Dog>{

	public CompareBreed() {

	}

	@Override
	public int compare(Dog o1, Dog o2) {
		
		return o1.getBreed().compareTo(o2.getBreed());
	}

}
