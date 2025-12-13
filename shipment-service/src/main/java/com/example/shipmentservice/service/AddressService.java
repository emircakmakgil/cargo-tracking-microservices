package com.example.shipmentservice.service;

import com.example.shipmentservice.data.dto.AddressDto.AddressListiningDto;
import com.example.shipmentservice.data.dto.AddressDto.CreateAddressDto;
import com.example.shipmentservice.data.dto.AddressDto.DeleteAddressDto;
import com.example.shipmentservice.data.dto.AddressDto.UpdateAddressDto;
import com.example.shipmentservice.data.entity.Address;

import java.util.List;
import java.util.UUID;

public interface AddressService {
    List<Address> findAll(List<UUID> addressId);
    Address findById(UUID id);
    void add(CreateAddressDto createAddressDto);
    List<AddressListiningDto> getAll();
    Address update(UpdateAddressDto updateAddressDto);
    void delete(DeleteAddressDto deleteAddressDto);
}
