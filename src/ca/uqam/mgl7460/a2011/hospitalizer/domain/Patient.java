package ca.uqam.mgl7460.a2011.hospitalizer.domain;

import java.util.Date;

import ca.uqam.mgl7460.a2011.hospitalizer.data.Persistable;

public class Patient extends Persistable {
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private Address address;
	private PatientFile patientFile;
	
	public Patient() {};
	
	public Patient(String firstName, String lastName, Date dateOfBirth) {
		super();
		setFirstName(firstName);
		setLastName(lastName);
		setDateOfBirth(dateOfBirth);
		this.address = new Address();
		this.patientFile = new PatientFile();
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public PatientFile getPatientFile() {
		return patientFile;
	}
	public void addObservation(Observation observation) {
		this.patientFile.add(observation);
	}
}
