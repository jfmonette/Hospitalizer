package ca.uqam.mgl7460.a2011.hospitalizer.domain;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class PatientFileTest {

	@Test
	public void test() {
		Observation expected = new Observation(new Date(), new Date(), "Description");
		PatientFile file = new PatientFile();
		file.add(expected);
		assertTrue(file.getObservations().contains(expected));
	}
}
