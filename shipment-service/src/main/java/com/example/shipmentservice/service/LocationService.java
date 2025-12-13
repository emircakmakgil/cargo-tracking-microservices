package com.example.shipmentservice.service;

import com.example.shipmentservice.data.dto.LocationDto.CreateLocationDto;
import com.example.shipmentservice.data.dto.LocationDto.DeleteLocationDto;
import com.example.shipmentservice.data.dto.LocationDto.LocationListiningDto;
import com.example.shipmentservice.data.dto.LocationDto.UpdateLocationDto;
import com.example.shipmentservice.data.entity.Location;

import java.util.List;
import java.util.UUID;

public interface LocationService {
    List<Location> findAll(List<UUID> locationId);
    Location findById(UUID id);
    void add(CreateLocationDto createLocationDto);
    List<LocationListiningDto> getAll();
    Location update(UpdateLocationDto updateLocationDto);
    void delete(DeleteLocationDto deleteLocationDto);
}
