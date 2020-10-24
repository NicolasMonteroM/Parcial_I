package model;

import java.util.Collections;
import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PConstants;

public class DogList {

	public LinkedList<Dog> peluditos;
	public PApplet app;

	private Dog d;

	private CompareDate compareDate;
	private CompareAge compareAge;
	private CompareName compareName;
	private CompareBreed compareBreed;
	private String sortAttribute;

	private String[] export;

	public DogList() {

		peluditos = new LinkedList<Dog>();
		compareDate = new CompareDate();
		compareAge = new CompareAge();
		compareName = new CompareName();
		compareBreed = new CompareBreed();
		sortAttribute = "None";
		export = new String[10];

	}

	public void addPeludito(String[] data1, String[] data2) {

		// ––––––––––––– Taking the info from the 2 .txt archives to create each dog

		for (int i = 0; i < data1.length; i++) {

			// ––––––––––––– First .txt ––––––––––––––––//
			
			String[] firstPart = data1[i].split(",");

			String name = firstPart[1].trim();
			int id = Integer.parseInt(firstPart[0].trim());
			int age = Integer.parseInt(firstPart[2].trim());

			for (int j = 0; j < data2.length; j++) {

				// ––––––––––––– Second .txt ––––––––––––––––//
				
				String[] secondPart = data2[j].split(",");

				String breed = secondPart[1].trim();
				String date = secondPart[2].trim();
				int id2 = Integer.parseInt(secondPart[0].trim());

				// ––––––––––––– Merging the info ––––––––––––––––//
				
				if (id == id2) {

					d = new Dog(app, id, name, age, breed, date);
					getList().add(d);

				}
			}
		}
	}

	public void drawList(PApplet app) {

		// ––––––––––––– Designing the interface ––––––––––––––––//

		app.textAlign(PConstants.CENTER);

		app.fill(16, 69, 255);

		app.textSize(17);
		app.text("Peludos sin hogar", app.width / 2, 45);

		int y = 30;
		int y1 = 50;
		int y2 = 80;
		int borderLeft = 50;
		int borderTop = 130;

		app.textSize(13);
		app.text("id #", borderLeft + 20, borderTop - y);
		app.text("Nombre", borderLeft + 100, borderTop - y);
		app.text("Edad", borderLeft + 200, borderTop - y);
		app.text("Raza", borderLeft + 300, borderTop - y);
		app.text("Fecha de nacimiento", borderLeft + 430, borderTop - y);
		app.fill(50);

		// ––––––––––––– Displaying the info ––––––––––––––––//

		for (int i = 0; i < getList().size(); i++) {

			app.text(getList().get(i).getId(), borderLeft + 20, borderTop + (i * y));
			app.text(getList().get(i).getName(), borderLeft + 100, borderTop + (i * y));
			app.text(getList().get(i).getAge(), borderLeft + 200, borderTop + (i * y));
			app.text(getList().get(i).getBreed(), borderLeft + 300, borderTop + (i * y));
			app.text(getList().get(i).getBirthDate().toString(), borderLeft + 430, borderTop + (i * y));

		}
		
		// ––––––––––––– Designing the instructions ––––––––––––––––//
		
		app.text("Presiona las siguientes teclas para ordenar la información según el criterio.", app.width / 2, app.height-120);
		app.text("id #", borderLeft + 20, app.height - y1);
		app.text("Nombre", borderLeft + 100, app.height - y1);
		app.text("Edad", borderLeft + 200, app.height - y1);
		app.text("Raza", borderLeft + 300, app.height - y1);
		app.text("Fecha de nacimiento", borderLeft + 430, app.height - y1);
		
		app.fill(16, 69, 255);
		app.text("I", borderLeft + 20, app.height - y2);
		app.text("N", borderLeft + 100, app.height - y2);
		app.text("E", borderLeft + 200, app.height - y2);
		app.text("R", borderLeft + 300, app.height - y2);
		app.text("F", borderLeft + 430, app.height - y2);
		
		app.textSize(11);
		app.text("Se creará un nuevo archivo con la información organizada según el criterio.", app.width / 2, app.height-20);
		
	}

	public void sortList(char c, PApplet app) {

		// ––––––––––––– Sorting according to different attributes by pressing keys ––––––––––––––––//
		
		switch (c) {

		case 'i':

			Collections.sort(getList());
			sortAttribute = "Id";
			exportList();

			break;

		case 'n':

			Collections.sort(getList(), compareName);
			sortAttribute = "Name";
			exportList();

			break;

		case 'e':

			Collections.sort(getList(), compareAge);
			sortAttribute = "Age";
			exportList();

			break;

		case 'r':

			Collections.sort(getList(), compareBreed);
			sortAttribute = "Breed";
			exportList();

			break;

		case 'f':

			Collections.sort(getList(), compareDate);
			sortAttribute = "Date";

			exportList();

			break;

		}
		
		// ––––––––––––– Saving the sorted list to a .txt archive ––––––––––––––––//
		
		app.saveStrings("data/exports/" + sortAttribute + "Export.txt", export);
	}

	public String getSortAttribute() {

		return sortAttribute;

	}

	public void exportList() {
		
		// ––––––––––––– Gattering the new sorted info into a new array in order to export it ––––––––––––––––//
		
		for (int i = 0; i < getList().size(); i++) {

			String infoExport = Integer.toString(getList().get(i).getId()) + ", "
					+ getList().get(i).getName().toLowerCase() + ", " + Integer.toString(getList().get(i).getAge())
					+ ", " + getList().get(i).getBreed().toLowerCase();

			export[i] = infoExport;

		}
	}

	public LinkedList<Dog> getList() {

		return peluditos;

	}
}
