package com.junit5.setup_junit_eclipse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class ContactServiceTest {
	
	@Test
	void testAddContact() {
	   ContactService contactService = new ContactService();
	   Contact contact = new Contact("1", "laurie", "testing", "1234568790", "1265 2nd st sw");
	   Contact contact1 = new Contact("2", "jordii", "again", "0987654321", "1335 5th st sw");
	   contactService.addContact(contact);
	   
	   Contact retrieved = contactService.addContact("1");
	   assertTrue(contact.getContactId().equals("1"));
	   
	   Contact retrieved1 = contactService.addContact("2");
	   assertTrue(contact1.getContactId().equals("2"));
	}
	
	@Test
	void testUpdateFirstName() {
	   ContactService contactService = new ContactService();
	   Contact contact = new Contact("1", "laurie", "testing", "1234568790", "1265 2nd st sw");
	   contactService.addContact(contact);

	   contactService.updateFirstName("1", "jordii");

	   Contact retrieved = contactService.lookupContact("1");
	   assertTrue(contact.getContactId().equals("1"));
	   assertTrue(contact.getFirstName().equals("jordii"));
	}
	
	@Test
	void testUpdateLastName() {
	   ContactService contactService = new ContactService();
	   Contact contact = new Contact("1", "laurie", "testing", "1234568790", "1265 2nd st sw");
	   contactService.addContact(contact);

	   contactService.updateLastName("1", "testing");

	   Contact retrieved = contactService.lookupContact("1");
	   assertTrue(contact.getContactId().equals("1"));
	   assertTrue(contact.getLastName().equals("testing"));
	  	}
	
	@Test
	void testUpdatePhoneNumber() {
	   ContactService contactService = new ContactService();
	   Contact contact = new Contact("1", "laurie", "testing", "1234568790", "1265 2nd st sw");
	   contactService.addContact(contact);
	   contactService.updatePhoneNumber("1", "1234568790");

	   Contact retrieved = contactService.lookupContact("1");
	   assertTrue(contact.getContactId().equals("1"));
	   assertTrue(contact.getPhoneNumber().equals("1234568790"));
	}
	
	@Test
	void testUpdateAddress() {
	   ContactService contactService = new ContactService();
	   Contact contact = new Contact("1", "laurie", "testing", "1234568790", "1265 2nd st sw");
	   contactService.addContact(contact);
	   contactService.updateAddress("1", "11904 70th place n");

	   Contact retrieved = contactService.lookupContact("1");
	   assertTrue(contact.getContactId().equals("1"));
	   assertTrue(contact.getAddress().equals("11904 70th place n"));
	}
	
	@Test
	void testUpdateAddressNull() {
	   ContactService contactService = new ContactService();
	   Contact contact = new Contact("1", "laurie", "testing", "1234568790", "1265 2nd st sw");
	   contactService.addContact(contact);
	   contactService.updateAddress("1", null);

	   Contact retrieved = contactService.lookupContact("1");
	   assertFalse(contact.getContactId().equals(null));
	  
	}
	
	@Test 
	void testDeleteContact() {
		ContactService contactService = new ContactService();
		Contact contact = new Contact("1", "laurie", "testing", "1234568790", "1265 2nd st sw");
		contactService.addContact(contact);
		contactService.deleteContact("1");
		
		Contact retrieved = contactService.lookupContact("1");	
	}
}