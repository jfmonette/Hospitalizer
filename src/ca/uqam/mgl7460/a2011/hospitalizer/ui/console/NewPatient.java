package ca.uqam.mgl7460.a2011.hospitalizer.ui.console;

import java.text.*;
import java.util.Date;
import ca.uqam.mgl7460.a2011.hospitalizer.data.PersistanceService;
import ca.uqam.mgl7460.a2011.hospitalizer.domain.Address;
import ca.uqam.mgl7460.a2011.hospitalizer.domain.Patient;
import ca.uqam.mgl7460.a2011.hospitalizer.util.InputReader;

public class NewPatient {
	public void show() {
		System.out.println("New patient");
		System.out.println("===========");
		Patient patient = new Patient();
		
		patient.setFirstName(getFirstName());
		patient.setLastName(getLastName());
		patient.setDateOfBirth(getDateOfBirth());
		patient.setAddress(getAddress());
		persist(patient);
	}
	private String getFirstName() {
		System.out.print("First Name: ");
		return InputReader.getInput();
	}
	private String getLastName() {
		System.out.print("Last Name: ");
		return InputReader.getInput();
	}
	private Date getDateOfBirth() {
		Date dateOfBirth;
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		System.out.print("Date of birth (" + format.format(new Date()) + ") : ");
		String dateString = InputReader.getInput();
		try {
			dateOfBirth = format.parse(dateString);
        }
        catch(ParseException pe) {
            System.out.println("ERROR: Cannot parse \"" + dateString + "\"");
            dateOfBirth = getDateOfBirth();
        }
		return dateOfBirth;
	}
	private Address getAddress() {
		Address address = new Address();
		System.out.print("Do you want to add an address for this patient (y/n) ? ");
		String addAddress = InputReader.getInput().toLowerCase();
		if (addAddress.equals("y")) {
			System.out.print("Civic number: ");
			address.setCivicNumber(InputReader.getInput());
			System.out.print("Street : ");
			address.setStreet(InputReader.getInput());
			System.out.print("City : ");
			address.setCity(InputReader.getInput());
			System.out.print("Province: ");
			address.setProvince(InputReader.getInput());
			System.out.print("Postal code : ");
			address.setPostalCode(InputReader.getInput());
		}
		return address;
	}
	private void persist(Patient patient) {
		PersistanceService persistance = new PersistanceService();
		persistance.persist(patient);
	}

}
