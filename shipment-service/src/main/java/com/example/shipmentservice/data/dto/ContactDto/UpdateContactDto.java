package com.example.shipmentservice.data.dto.ContactDto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class UpdateContactDto {
    private UUID id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private LocalDateTime updateAt;
}
