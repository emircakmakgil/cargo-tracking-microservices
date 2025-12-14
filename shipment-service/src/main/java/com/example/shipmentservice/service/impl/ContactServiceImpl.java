package com.example.shipmentservice.service.impl;

import com.example.shipmentservice.core.exception.type.BusinessException;
import com.example.shipmentservice.data.dto.ContactDto.ContactListiningDto;
import com.example.shipmentservice.data.dto.ContactDto.CreateContactDto;
import com.example.shipmentservice.data.dto.ContactDto.DeleteContactDto;
import com.example.shipmentservice.data.dto.ContactDto.UpdateContactDto;
import com.example.shipmentservice.data.entity.Contact;
import com.example.shipmentservice.mapper.ContactMapper;
import com.example.shipmentservice.repository.ContactRepository;
import com.example.shipmentservice.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.example.shipmentservice.constant.GeneralConstant.CONTACT_NOT_FOUND;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public ContactServiceImpl(ContactRepository contactRepository, ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }


    @Override
    public List<Contact> findAll(List<UUID> contactId) {
        return contactRepository.findAllById(contactId);
    }

    @Override
    public Contact findById(UUID id) {
        return contactRepository.findById(id).orElseThrow(()-> new BusinessException(CONTACT_NOT_FOUND + id));
    }

    @Override
    public void add(CreateContactDto createContactDto) {
        Contact contact=contactMapper.createContactFromCreateContactDto(createContactDto);
        contactRepository.saveAndFlush(contact);
    }

    @Override
    public List<ContactListiningDto> getAll() {
        List<Contact> contacts=contactRepository.findAll();
        List<ContactListiningDto> contactListiningDtos=contacts.stream().map(contactMapper::toContractListiningDto).collect(Collectors.toList());
        return contactListiningDtos;
    }

    @Override
    public Contact update(UpdateContactDto updateContactDto) {
        Contact contact=contactRepository.findById(updateContactDto.getId()).orElseThrow(()-> new RuntimeException(CONTACT_NOT_FOUND));
        contactMapper.updateContractFromUpdateContractDto(updateContactDto,contact);
        return contact;
    }

    @Override
    public void delete(DeleteContactDto deleteContactDto) {
        Contact contact=contactRepository.findById(deleteContactDto.getId()).orElseThrow(()-> new RuntimeException(CONTACT_NOT_FOUND));
        contactRepository.delete(contact);
    }
}
