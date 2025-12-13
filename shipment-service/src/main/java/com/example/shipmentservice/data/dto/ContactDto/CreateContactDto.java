package com.example.shipmentservice.data.dto.ContactDto;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateContactDto {

    private String fullName;
    private String phoneNumber;
    private String email;

}
