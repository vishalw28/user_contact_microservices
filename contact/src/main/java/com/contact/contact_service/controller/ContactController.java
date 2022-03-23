package com.contact.contact_service.controller;

import com.contact.contact_service.entity.Contact;
import com.contact.contact_service.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/{id}")
    public List<Contact> getContactListForUserId(@PathVariable("id") Long id){
        return contactService.getContactOfUser(id);
    }
}
