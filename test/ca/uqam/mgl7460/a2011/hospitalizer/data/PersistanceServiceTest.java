package ca.uqam.mgl7460.a2011.hospitalizer.data;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.Date;
import org.junit.Test;
import ca.uqam.mgl7460.a2011.hospitalizer.domain.*;
import ca.uqam.mgl7460.a2011.hospitalizer.security.*;
import ca.uqam.mgl7460.a2011.hospitalizer.security.roles.*;

public class PersistanceServiceTest {

	@Test
	public void itTestsPersistingUser() {
		User expected = new User("jsmith", "John", "Smith", "123");
		expected.addRole(new Clerk());
		PersistanceService persistance = new PersistanceService();
		persistance.persist(expected);
		Collection<Persistable> users = persistance.getObjects(expected.getClass());
		assertTrue(users.contains(expected));		
	}
	
	@Test
	public void itTestsPersistingAddress() {
		Address expected = new Address("123", "Sainte-Catherine", "Montreal", "QC", "H0H 0H0");
		PersistanceService persistance = new PersistanceService();
		persistance.persist(expected);
		Collection<Persistable> addresses = persistance.getObjects(expected.getClass());
		assertTrue(addresses.contains(expected));		
	}
	
	@Test
	public void itTestsPersistingPatient() {
		Patient expected = new Patient("John", "Smith", new Date());
		expected.addObservation(new Observation(new Date(), new Date(), "John has high blood glucose level."));
		expected.addObservation(new Observation(new Date(), new Date(), "John suffers from hyperglycemia ."));
		PersistanceService persistance = new PersistanceService();
		persistance.persist(expected);
		Collection<Persistable> patients = persistance.getObjects(expected.getClass());
		assertTrue(patients.contains(expected));		
	}
}
