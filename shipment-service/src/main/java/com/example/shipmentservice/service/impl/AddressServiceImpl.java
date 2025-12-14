package com.example.shipmentservice.service.impl;

import com.example.shipmentservice.core.exception.type.BusinessException;
import com.example.shipmentservice.data.dto.AddressDto.AddressListiningDto;
import com.example.shipmentservice.data.dto.AddressDto.CreateAddressDto;
import com.example.shipmentservice.data.dto.AddressDto.DeleteAddressDto;
import com.example.shipmentservice.data.dto.AddressDto.UpdateAddressDto;
import com.example.shipmentservice.data.entity.Address;
import com.example.shipmentservice.mapper.AddressMapper;
import com.example.shipmentservice.repository.AddressRepository;
import com.example.shipmentservice.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.example.shipmentservice.constant.GeneralConstant.ADDRESS_NOT_FOUND;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public List<Address> findAll(List<UUID> addressId) {
        return addressRepository.findAllById(addressId);
    }

    @Override
    public Address findById(UUID id) {
        return addressRepository.findById(id).orElseThrow(()-> new BusinessException(ADDRESS_NOT_FOUND+id));
    }

    @Override
    public void add(CreateAddressDto createAddressDto) {
        Address address=addressMapper.createAddressFromCreateAddressDto(createAddressDto);
        addressRepository.saveAndFlush(address);
    }

    @Override
    public List<AddressListiningDto> getAll() {
        List<Address> addressList=addressRepository.findAll();
        return addressList.stream().map(addressMapper::toAddressListiningDto).collect(Collectors.toList());
    }

    @Override
    public Address update(UpdateAddressDto updateAddressDto) {
        Address address=addressRepository.findById(updateAddressDto.getId()) .orElseThrow(() -> new BusinessException(ADDRESS_NOT_FOUND));
        addressMapper.updateAddressFromUpdateAddressDto(updateAddressDto,address);
        return addressRepository.saveAndFlush(address);
    }

    @Override
    public void delete(DeleteAddressDto deleteAddressDto) {
        Address address=addressRepository.findById(deleteAddressDto.getId()).orElseThrow(()-> new BusinessException(ADDRESS_NOT_FOUND));
        addressRepository.delete(address);
    }
}
