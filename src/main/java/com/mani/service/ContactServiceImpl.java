package com.mani.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mani.dao.ContactDtlsEntity;
import com.mani.dao.ContactDtlsRepository;
import com.mani.model.Contact;
@Service
public class ContactServiceImpl implements IContactService {
	@Autowired
	private ContactDtlsRepository repo;
	
	/**
	 * This method is used to save the contact details
	 */
	@Override
	public boolean saveContact(Contact contact) {
		ContactDtlsEntity entity=new ContactDtlsEntity();
		//copying the data from pojo object to entity object 
		//bcz save method is expecting entity
		BeanUtils.copyProperties(contact, entity);
		ContactDtlsEntity savedEntity = repo.save(entity);
		return savedEntity.getCid()!=null;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> listCnct=new ArrayList<>();
		List<ContactDtlsEntity> listCnctEntity = repo.findAll();
		listCnctEntity.forEach(entity->{
			Contact contact=new Contact();
			BeanUtils.copyProperties(entity, contact);
			listCnct.add(contact);
		});
		return listCnct;
	}

	@Override
	public Contact getOneContact(Integer id) {
		Contact contact=new Contact();
		Optional<ContactDtlsEntity> findById = repo.findById(id);
		if(findById.isPresent())
		{
			ContactDtlsEntity contactDtlsEntity = findById.get();
			BeanUtils.copyProperties(contactDtlsEntity, contact);
			return contact;
		}
		else
		return null;
	}

	@Override
	public boolean deleteContact(Integer id) {
		repo.deleteById(id);
		return true;
	}

	
}
