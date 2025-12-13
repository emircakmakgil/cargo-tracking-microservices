package com.example.shipmentservice.data.dto.AddressDto;


import com.example.shipmentservice.model.enums.AddressType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class UpdateAddressDto {
    private UUID id;
    private String street;
    private String buildingNumber;
    private String apartmentNumber;
    private String district;
    private String city;
    private String country;
    private String zipCode;
    private AddressType addressType;
    private LocalDateTime updateAt;
}
