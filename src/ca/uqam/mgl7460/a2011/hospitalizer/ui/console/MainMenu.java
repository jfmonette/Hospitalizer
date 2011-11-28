package ca.uqam.mgl7460.a2011.hospitalizer.ui.console;

import ca.uqam.mgl7460.a2011.hospitalizer.util.InputReader;

public class MainMenu {
	public void show() {
		System.out.println("Main menu");
		System.out.println("=========");
		System.out.println("1-Create new patient");
		System.out.println("2-List patients");
		System.out.println("3-Exit");
		System.out.print("?");
		String menuOption = InputReader.getInput();
		if (!menuOption.equals("3")) {
			handleMenuOption(menuOption);
		}
	}

	private void handleMenuOption(String menuOption) {
		if (menuOption.equals("1"))
			handleNewPatient();
		if (menuOption.equals("2"))
			handleListPatients();
		if (menuOption.equals("3"))
			System.out.println("Exit");
		show();
	}

	private void handleNewPatient() {
		NewPatient newPatient = new NewPatient();
		newPatient.show();
		
	}

	private void handleListPatients() {
		ListPatients listPatients = new ListPatients();
		listPatients.show();
	}

}
