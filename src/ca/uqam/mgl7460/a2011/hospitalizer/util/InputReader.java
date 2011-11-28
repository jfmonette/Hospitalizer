package ca.uqam.mgl7460.a2011.hospitalizer.util;

import java.util.Scanner;

public abstract class InputReader {
	public static String getInput() {
		String input;
		Scanner scanner = new Scanner(System.in);
		input = scanner.next();
		return input;
	}
}
