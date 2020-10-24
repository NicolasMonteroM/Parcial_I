package view;

import controller.Controller;
import processing.core.PApplet;

public class Main extends PApplet {

	Controller controller;
	PApplet app;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}

	@Override
	public void settings() {

		size(600, 600);

	}

	@Override
	public void setup() {

		controller = new Controller(this);
		controller.loadInfo();

	}

	@Override
	public void draw() {

		background(255);
		controller.drawController(this);

	}

	@Override
	public void keyPressed() {
		
		controller.keyboardController(key);

	}
}
