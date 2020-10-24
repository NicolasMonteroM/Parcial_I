package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import processing.core.PApplet;

public class Dog implements Comparable<Dog> {

	public int id;
	public String name;
	public int age;
	public LocalDate birthDate;
	public String breed;

	protected PApplet app;

	public Dog(PApplet app, int id, String name, int age, String breed, String date) {

		this.app = app;
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.age = age;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
		this.birthDate = LocalDate.parse(date,formatter);
	}
	
	
	//–––––––––– Natural sort by Id ––––––––––––––
	
	
	@Override
	public int compareTo(Dog o) {
	
		return  id-o.getId();
	}
	
	//–––––––––– getters and setters ––––––––––––
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

}
