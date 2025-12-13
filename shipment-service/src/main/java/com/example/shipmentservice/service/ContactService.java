package com.example.shipmentservice.service;

import com.example.shipmentservice.data.dto.ContactDto.ContactListiningDto;
import com.example.shipmentservice.data.dto.ContactDto.CreateContactDto;
import com.example.shipmentservice.data.dto.ContactDto.DeleteContactDto;
import com.example.shipmentservice.data.dto.ContactDto.UpdateContactDto;
import com.example.shipmentservice.data.entity.Contact;

import java.util.List;
import java.util.UUID;

public interface ContactService {
    List<Contact> findAll(List<UUID> contactId);
    Contact findById(UUID id);
    void add(CreateContactDto createContactDto);
    List<ContactListiningDto> getAll();
    Contact update(UpdateContactDto updateContactDto);
    void delete(DeleteContactDto deleteContactDto);

}
