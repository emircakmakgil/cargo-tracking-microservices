package com.example.shipmentservice.service;

import com.example.shipmentservice.data.dto.ServiceTypeDto.CreateServiceTypeDto;
import com.example.shipmentservice.data.dto.ServiceTypeDto.DeleteServiceTypeDto;
import com.example.shipmentservice.data.dto.ServiceTypeDto.ServiceTypeListiningDto;
import com.example.shipmentservice.data.dto.ServiceTypeDto.UpdateServiceTypeDto;
import com.example.shipmentservice.data.entity.ServiceType;

import java.util.List;
import java.util.UUID;

public interface ServiceTypeService {
    List<ServiceType> findAll(List<UUID> serviceTypeId);
    ServiceType findById(UUID id);
    void add(CreateServiceTypeDto createServiceTypeDto);
    List<ServiceTypeListiningDto> getAll();
    ServiceType update(UpdateServiceTypeDto updateServiceTypeDto);
    void delete(DeleteServiceTypeDto deleteServiceTypeDto);
}
