package view;

import processing.core.PApplet;

public class Main extends PApplet{
	

	PApplet app;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}

	@Override
	public void settings() {
		
		size(600,600);
		
		
	}
	
	@Override
	public void setup() {
		
		//controller = new Controller(this);
		
	}
	
	@Override
	public void draw() {
		
		background(50);
		
	}
	
	@Override
	public void mousePressed() {

	}
}
