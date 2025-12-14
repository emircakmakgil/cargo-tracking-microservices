package com.example.shipmentservice.service.impl;

import com.example.shipmentservice.core.exception.type.BusinessException;
import com.example.shipmentservice.data.dto.ServiceTypeDto.CreateServiceTypeDto;
import com.example.shipmentservice.data.dto.ServiceTypeDto.DeleteServiceTypeDto;
import com.example.shipmentservice.data.dto.ServiceTypeDto.ServiceTypeListiningDto;
import com.example.shipmentservice.data.dto.ServiceTypeDto.UpdateServiceTypeDto;
import com.example.shipmentservice.data.entity.ServiceType;
import com.example.shipmentservice.mapper.ServiceTypeMapper;
import com.example.shipmentservice.repository.ServiceTypeRepository;
import com.example.shipmentservice.service.ServiceTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.example.shipmentservice.constant.GeneralConstant.SERVICE_TYPE_NOT_FOUND;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService{
    private final ServiceTypeRepository serviceTypeRepository;
    private final ServiceTypeMapper serviceTypeMapper;

    public ServiceTypeServiceImpl(ServiceTypeRepository serviceTypeRepository, ServiceTypeMapper serviceTypeMapper) {
        this.serviceTypeRepository = serviceTypeRepository;
        this.serviceTypeMapper = serviceTypeMapper;
    }

    @Override
    public List<ServiceType> findAll(List<UUID> serviceTypeId) {
        return serviceTypeRepository.findAllById(serviceTypeId);
    }

    @Override
    public ServiceType findById(UUID id) {
        return serviceTypeRepository.findById(id).orElseThrow(()-> new BusinessException(SERVICE_TYPE_NOT_FOUND +" : "+id));
    }

    @Override
    public void add(CreateServiceTypeDto createServiceTypeDto) {
        ServiceType serviceType= serviceTypeMapper.createServiceTypeFromCreatedServiceType(createServiceTypeDto);
        serviceTypeRepository.saveAndFlush(serviceType);
    }

    @Override
    public List<ServiceTypeListiningDto> getAll() {
        List<ServiceType> serviceTypes=serviceTypeRepository.findAll();
        return serviceTypes.stream().map(serviceTypeMapper::toServiceTypeListiningDto).collect(Collectors.toList());
    }

    @Override
    public ServiceType update(UpdateServiceTypeDto updateServiceTypeDto) {
        ServiceType serviceType=serviceTypeRepository.findById(updateServiceTypeDto.getId()).orElseThrow(()-> new BusinessException(SERVICE_TYPE_NOT_FOUND+ " : "+updateServiceTypeDto.getId()));
        serviceTypeMapper.updateServiceTypeFromUpdatedServiceTypeDto(updateServiceTypeDto,serviceType);
        return serviceType;
    }

    @Override
    public void delete(DeleteServiceTypeDto deleteServiceTypeDto) {
        ServiceType serviceType=serviceTypeRepository.findById(deleteServiceTypeDto.getId()).orElseThrow(()-> new BusinessException(SERVICE_TYPE_NOT_FOUND+" : "+ deleteServiceTypeDto.getId()));
        serviceTypeRepository.saveAndFlush(serviceType);
    }
}
