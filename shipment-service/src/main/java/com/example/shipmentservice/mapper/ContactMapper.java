package com.example.shipmentservice.mapper;

import com.example.shipmentservice.data.dto.ContactDto.ContactListiningDto;
import com.example.shipmentservice.data.dto.ContactDto.CreateContactDto;
import com.example.shipmentservice.data.dto.ContactDto.UpdateContactDto;
import com.example.shipmentservice.data.entity.Contact;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class ContactMapper {
    public Contact createContactFromCreateContactDto(CreateContactDto createContactDto){
        return Contact.builder()
                .fullName(createContactDto.getFullName())
                .phoneNumber(createContactDto.getPhoneNumber())
                .email(createContactDto.getEmail())
                .build();
    }
    public void updateContractFromUpdateContractDto(UpdateContactDto updateContactDto, Contact contact){
        contact.setFullName(updateContactDto.getFullName());
        contact.setPhoneNumber(updateContactDto.getPhoneNumber());
        contact.setEmail(updateContactDto.getEmail());
        contact.setUpdateDate(LocalDateTime.now());
    }
    public ContactListiningDto toContractListiningDto(Contact contact){
        return new ContactListiningDto(
                contact.getFullName(),
                contact.getPhoneNumber(),
                contact.getEmail()
        );
    }

}
