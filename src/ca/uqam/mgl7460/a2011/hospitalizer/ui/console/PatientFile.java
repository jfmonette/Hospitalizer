package ca.uqam.mgl7460.a2011.hospitalizer.ui.console;

import java.text.SimpleDateFormat;
import ca.uqam.mgl7460.a2011.hospitalizer.domain.*;

public class PatientFile {
	private Patient patient;
	
	public PatientFile(Patient patient) {
		this.patient = patient;
	}
	public void show() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		ca.uqam.mgl7460.a2011.hospitalizer.domain.PatientFile file = this.patient.getPatientFile();
		System.out.println("Patient file");
		System.out.println("============");
		System.out.println("Patient name:" + patient.getLastName() + ", " + patient.getFirstName());
		System.out.println("Date of birth: " + format.format(patient.getDateOfBirth()));
		for (Observation observation : file.getObservations()) {
			System.out.println("Observations :");
			System.out.println("  Observed : " + format.format(observation.getObservedDate()));
			System.out.println("  Recorded : " + format.format(observation.getRecordedDate()));
			System.out.println("  Description : " + observation.getDescription());
			System.out.println();
		}
	}
}
