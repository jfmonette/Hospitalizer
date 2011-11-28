package ca.uqam.mgl7460.a2011.hospitalizer.domain;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class PatientTest {

	@Test
	public void testPatient() {
		String expectedFirstName = "John";
		String expectedLastName = "Smith";
		Date expectedDateOfBirth = new Date();
		Patient patient = new Patient(expectedFirstName, expectedLastName, expectedDateOfBirth);
		assertEquals(expectedFirstName, patient.getFirstName());
		assertEquals(expectedLastName, patient.getLastName());
		assertEquals(expectedDateOfBirth, patient.getDateOfBirth());
	}
}
