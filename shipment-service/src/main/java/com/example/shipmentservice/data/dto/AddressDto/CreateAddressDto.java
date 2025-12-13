package com.example.shipmentservice.data.dto.AddressDto;

import com.example.shipmentservice.model.enums.AddressType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAddressDto {

    private String street;
    private String buildingNumber;
    private String apartmentNumber;
    private String district;
    private String city;
    private String country;
    private String zipCode;
    private AddressType addressType;
}
