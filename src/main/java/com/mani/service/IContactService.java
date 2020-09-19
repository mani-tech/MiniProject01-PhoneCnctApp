package com.mani.service;

import java.util.List;

import com.mani.model.Contact;

public interface IContactService {

	public boolean saveContact(Contact contact);
	
	public List<Contact> getAllContacts();
	
	public Contact getOneContact(Integer id);
	
	public boolean deleteContact(Integer id);
	
}
