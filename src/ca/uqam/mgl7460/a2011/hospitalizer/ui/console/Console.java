package ca.uqam.mgl7460.a2011.hospitalizer.ui.console;

import ca.uqam.mgl7460.a2011.hospitalizer.application.SecurityService;
import ca.uqam.mgl7460.a2011.hospitalizer.security.User;
import ca.uqam.mgl7460.a2011.hospitalizer.util.InputReader;

public class Console {
	
	public static void main(String[] args) {
		System.out.println("Welcome to Hospitalizer");
		System.out.println("=======================");
		System.out.println("Please login");
		authenticateUser();
	}
	
	private static void authenticateUser() {
		System.out.print("User name: ");
		String userName = InputReader.getInput();
		System.out.print("Password: ");
		String password = InputReader.getInput();
		if(isAuthenticatedUser(userName, password)) {
			MainMenu menu = new MainMenu();
			System.out.println("");
			System.out.println("");
			menu.show();
		}
		else {
			System.out.println("Wrong username or password.");
			authenticateUser();
		}
	}

	private static boolean isAuthenticatedUser(String userName, String password) {
		boolean isAuthenticated = false;
		SecurityService security = new SecurityService();
		User user = security.authenticate(userName, password);
		if (user != null)
			isAuthenticated = true;
		return isAuthenticated;
	}
}
