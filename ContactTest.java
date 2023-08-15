package com.junit5.setup_junit_eclipse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.junit5.setup_junit_eclipse.Contact;

class ContactTest {

	@Test
	void testContact() {
		Contact contact = new Contact("1", "laurie", "testing", "1234568790", "1265 2nd st sw");
		assertTrue(contact.getContactId().equals("1"));
		assertTrue(contact.getFirstName().equals("laurie"));
		assertTrue(contact.getLastName().equals("testing"));
		assertTrue(contact.getPhoneNumber().equals("1234568790"));
		assertTrue(contact.getAddress().equals("1265 2nd st sw"));
		}
	
	@Test
	void testContactIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678970","laurie", "testing","1234568790","1265 2nd st sw");
		});	
	}
	
	@Test
	void testContactIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "laurie", "testing","1234568790","1265 2nd st sw");
		});	
	}
	
	@Test void testFirstNameTooLong(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "laurieeeeeeeeee", "testing", "1234568790", "1265 2nd st sw");
		});
	}
	
	@Test void testFirstNameNull(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", null, "testing", "1234568790", "1265 2nd st sw");
		});
	}
	
	@Test void testLastNameTooLong(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "laurie", "testinggggggggg", "1234568790", "1265 2nd st sw");
		});
	}
	
	@Test void testLastNameNull(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "laurie", null, "1234568790", "1265 2nd st sw");
		});
	}
	
	@Test void testPhoneNumberNotTen(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "laurie", "testing", "1234568790000000", "1265 2nd st sw");
		});
	}
	
	@Test void testPhoneNumberNull(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "laurie", "testing", null, "1265 2nd st sw");
		});
	}
	
	@Test void testAddressNull(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "laurie", "testing", "1234568790", null);
		});
	}
	
	@Test void testAddressTooLong(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "laurie", "testing", "1234568790", "1265 2nd st sw                     ");
		});
	}
}