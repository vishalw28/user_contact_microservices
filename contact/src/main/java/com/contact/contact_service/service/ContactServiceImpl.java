package com.contact.contact_service.service;

import com.contact.contact_service.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ContactServiceImpl implements ContactService{
    List<Contact> list = Arrays.asList(
        new Contact(101L, "amit1090@gmail.com","Amit",1L),
        new Contact(102L, "anil1090@gmail.com","Anil",1L),
        new Contact(103L, "dhanu@gmail.com","Dhanu",1L),
        new Contact(104L, "shailesh1090@gmail.com","Shailesh",2L),
        new Contact(105L, "sachin1090@gmail.com","Sachin",2L)
    );
    @Override
    public List<Contact> getContactOfUser(Long id) {
        return list.stream().filter(contact -> contact.getUserId().equals(id)).collect(Collectors.toList());
    }
}
