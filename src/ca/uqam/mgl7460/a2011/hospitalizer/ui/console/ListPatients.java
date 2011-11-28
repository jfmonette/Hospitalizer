package ca.uqam.mgl7460.a2011.hospitalizer.ui.console;

import java.util.*;
import ca.uqam.mgl7460.a2011.hospitalizer.data.*;
import ca.uqam.mgl7460.a2011.hospitalizer.domain.*;
import ca.uqam.mgl7460.a2011.hospitalizer.util.InputReader;

public class ListPatients {
	private SortedMap<Integer, Patient> patients = new TreeMap<Integer, Patient>();
	
	public void show() {
		System.out.println("Patients");
		System.out.println("========");
		PersistanceService persistance = new PersistanceService();
		Collection<Persistable> objects = persistance.getObjects(Patient.class);
		int i = 1;
		for (Persistable object : objects) {
			Patient patient = (Patient) object;
			patients.put(i, patient);
			System.out.println(i + "-" + patient.getLastName() + ", " + patient.getFirstName());
			++i;
		}
		showOptions();
	}

	private void showOptions() {
		System.out.println();
		System.out.println("Enter a patient # to see the patient's file ('q' to return to main menu).");
		System.out.print("?");
		String menuOption = InputReader.getInput();
		if (!menuOption.equals("q")) {
			handleMenuOption(menuOption);
		}	
	}

	private void handleMenuOption(String menuOption) {
		int choice = Integer.parseInt(menuOption);
		if (choice < patients.size()) {
			Patient patient = patients.get(choice);
			PatientFile file = new PatientFile(patient);
			file.show();
			show();
		}
		else {
			showOptions();
		}
	}
}
