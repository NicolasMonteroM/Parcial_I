package model;

import java.util.Comparator;

public class CompareName implements Comparator<Dog>{

	public CompareName() {

	}

	@Override
	public int compare(Dog o1, Dog o2) {

		return o1.getName().compareTo(o2.getName());
	}

}
