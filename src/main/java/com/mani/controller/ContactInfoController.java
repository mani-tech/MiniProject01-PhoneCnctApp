package com.mani.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mani.model.Contact;
import com.mani.service.IContactService;
@Controller
public class ContactInfoController {
	
	Logger logger=LoggerFactory.getLogger(ContactInfoController.class);
	@Autowired
	private IContactService service;
	
	@GetMapping(value= {"/","loadForm"})
	public String loadFormPage(Model model)
	{
		logger.debug("***loadFormPage method got started ");
		//empty contact object
		Contact contactObj=new Contact();
		//sending empty object to ui
		model.addAttribute("contact", contactObj);
		logger.debug("***loadFormPage method got ended ***");
		logger.info("***loadFormPage method executed successfully ***");
		return "index";	
	}
	@PostMapping("/saveContact")
	public String handleSubmitBtn(@ModelAttribute("contact") Contact contact,RedirectAttributes attribute)
	{
		logger.debug("***handleSubmitBtn method got started ");
		boolean saveContact = service.saveContact(contact);
		if(saveContact)
		{
			if(contact.getCid()!=null)
			{
				
				attribute.addFlashAttribute("updateMsg", "Contact updated successfully");
				logger.info("***contact updated successfully *** ");
			}
			else
			{
			attribute.addFlashAttribute("successMsg", "Contact saved successfullyyyyyy");
			logger.info("***contact saved successfully *** ");

			}
		}
		else
		{
			attribute.addFlashAttribute("failedMsg", "Contact failed to save");
			logger.error("contact failed to save");
		}
		logger.debug("***handleSubmitBtn method got ended ");

		return "redirect:/loadForm";
	}
	
	@GetMapping("/viewAllCnct")
	public String handleViewCtctsHyperlink(Model model)
	{
		List<Contact> allContacts = service.getAllContacts();
		model.addAttribute("contact", allContacts);
		return "viewContacts";
	}
}
