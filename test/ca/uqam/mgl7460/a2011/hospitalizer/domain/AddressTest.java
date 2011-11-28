package ca.uqam.mgl7460.a2011.hospitalizer.domain;

import static org.junit.Assert.*;
import org.junit.Test;

public class AddressTest {

	@Test
	public void testGetCivicNumber() {
		String expectedCivicNumber = "123";
		String expectedStreet = "Sainte-Catherine";
		String expectedCity = "Montreal";
		String expectedProvince = "QC";
		String expectedPostalCode = "H0H 0H0";
		Address address = new Address(expectedCivicNumber, expectedStreet, expectedCity, expectedProvince, expectedPostalCode);
		assertEquals(expectedCivicNumber, address.getCivicNumber());
		assertEquals(expectedStreet, address.getStreet());
		assertEquals(expectedCity, address.getCity());
		assertEquals(expectedProvince, address.getProvince());
		assertEquals(expectedPostalCode, address.getPostalCode());
	}
}
