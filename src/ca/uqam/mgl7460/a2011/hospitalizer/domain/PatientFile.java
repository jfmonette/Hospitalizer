package ca.uqam.mgl7460.a2011.hospitalizer.domain;

import java.util.*;

public class PatientFile {
	Collection<Observation> observations = new ArrayList<Observation>();
	
	public PatientFile() {
		
	}
	
	public void add(Observation observation) {
		this.observations.add(observation);
	}
	
	public Collection<Observation> getObservations() {
		return this.observations;
	}
}
