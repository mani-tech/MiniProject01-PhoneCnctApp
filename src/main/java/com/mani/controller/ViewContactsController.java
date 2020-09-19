package com.mani.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mani.model.Contact;
import com.mani.service.IContactService;
@Controller
public class ViewContactsController {
	@Autowired
	private IContactService service;
	
	@GetMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer id,Model model)
	{
		Contact contactObj = service.getOneContact(id);
		System.out.println("edit contact ");
		System.out.println(contactObj);
		model.addAttribute("contact", contactObj);
		return "index";
	}
	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid") Integer id,RedirectAttributes attribute)
	{
		service.deleteContact(id);
		attribute.addFlashAttribute("deleteMsg", "Record Deleted Successfully");
		return "redirect:viewAllCnct";
	}
}
