package ca.uqam.mgl7460.a2011.hospitalizer.security;

import static org.junit.Assert.*;
import org.junit.Test;
import ca.uqam.mgl7460.a2011.hospitalizer.security.roles.*;

public class UserTest {

	@Test
	public void testUser() {
		String expectedUserName = "jsmith";
		String expectedFirstName = "John";
		String expectedLastName = "Smith";
		String expectedPassword = "123";
		User user = new User(expectedUserName, expectedFirstName, expectedLastName, expectedPassword);
		assertEquals(expectedUserName,user.getUserName());
		assertEquals(expectedFirstName,user.getFirstName());
		assertEquals(expectedLastName,user.getLastName());
		assertEquals(expectedPassword,user.getPassword());
	}
	
	@Test
	public void testRoles() {
		Role expected = new Clerk();
		User user = new User("jsmith", "John", "Smith", "123");
		user.addRole(new Clerk());
		assertTrue(user.getRoles().contains(expected));
	}
}
