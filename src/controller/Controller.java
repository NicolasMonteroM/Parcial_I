package controller;

import model.DogList;
import model.Logica;
import processing.core.PApplet;

public class Controller {

	public Logica logica;
	public DogList peluditos;

	public String[] data1;
	public String[] data2;

	public PApplet app;

	public Controller(PApplet app) {

		this.app = app;
		peluditos = new DogList();
		logica = new Logica();

	}

	public void loadInfo() {

		// ––––––––––––– Loading the .txt archives ––––––––––––––––//
		
		data1 = app.loadStrings("../data/imports/datosUno.txt");
		data2 = app.loadStrings("../data/imports/datosDos.txt");

		peluditos.addPeludito(data1, data2);

	}

	public void drawController(PApplet app) {

		this.app = app;
		peluditos.drawList(app);

	}

	public void keyboardController(char c) {

		peluditos.sortList(c, app);

	}

	public void exportList() {

		
	}

}
