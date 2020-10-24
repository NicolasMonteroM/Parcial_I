package model;

import java.util.Comparator;

public class CompareDate implements Comparator<Dog> {

	public CompareDate() {

	}

	@Override
	public int compare(Dog o1, Dog o2) {

		return o1.getBirthDate().compareTo(o2.getBirthDate());
	}

}
