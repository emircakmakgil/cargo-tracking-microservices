package com.example.shipmentservice.mapper;

import com.example.shipmentservice.data.dto.AddressDto.AddressListiningDto;
import com.example.shipmentservice.data.dto.AddressDto.CreateAddressDto;
import com.example.shipmentservice.data.dto.AddressDto.UpdateAddressDto;
import com.example.shipmentservice.data.entity.Address;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class AddressMapper {
    public Address createAddressFromCreateAddressDto(CreateAddressDto createAddressDto){
        return Address.builder()
                .street(createAddressDto.getStreet())
                .buildingNumber(createAddressDto.getBuildingNumber())
                .apartmentNumber(createAddressDto.getApartmentNumber())
                .district(createAddressDto.getDistrict())
                .city(createAddressDto.getCity())
                .country(createAddressDto.getCountry())
                .zipCode(createAddressDto.getZipCode())
                .addressType(createAddressDto.getAddressType())
                .build();
    }
    public void updateAddressFromUpdateAddressDto(UpdateAddressDto updateAddressDto,Address address){
        address.setStreet(updateAddressDto.getStreet());
        address.setBuildingNumber(updateAddressDto.getBuildingNumber());
        address.setApartmentNumber(updateAddressDto.getApartmentNumber());
        address.setDistrict(updateAddressDto.getDistrict());
        address.setCity(updateAddressDto.getCity());
        address.setCountry(updateAddressDto.getCountry());
        address.setZipCode(updateAddressDto.getZipCode());
        address.setAddressType(updateAddressDto.getAddressType());
        address.setUpdateDate(LocalDateTime.now());
    }
    public AddressListiningDto toAddressListiningDto(Address address){
        return new AddressListiningDto(
                address.getStreet(),
                address.getBuildingNumber(),
                address.getApartmentNumber(),
                address.getDistrict(),
                address.getCity(),
                address.getCountry(),
                address.getZipCode(),
                address.getAddressType()
        );
    }
}
