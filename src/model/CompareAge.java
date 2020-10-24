package model;

import java.util.Comparator;

public class CompareAge implements Comparator<Dog> {

	public CompareAge() {

	}

	@Override
	public int compare(Dog o1, Dog o2) {

		return o1.getAge() - o2.getAge();
	}

}
