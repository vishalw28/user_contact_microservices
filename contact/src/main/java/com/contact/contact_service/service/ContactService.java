package com.contact.contact_service.service;

import com.contact.contact_service.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ContactService {
    List<Contact> getContactOfUser(Long id);
}
