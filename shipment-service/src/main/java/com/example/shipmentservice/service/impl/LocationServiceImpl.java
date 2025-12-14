package com.example.shipmentservice.service.impl;

import com.example.shipmentservice.core.exception.type.BusinessException;
import com.example.shipmentservice.data.dto.LocationDto.CreateLocationDto;
import com.example.shipmentservice.data.dto.LocationDto.DeleteLocationDto;
import com.example.shipmentservice.data.dto.LocationDto.LocationListiningDto;
import com.example.shipmentservice.data.dto.LocationDto.UpdateLocationDto;
import com.example.shipmentservice.data.entity.Location;
import com.example.shipmentservice.mapper.LocationMapper;
import com.example.shipmentservice.repository.LocationRepository;
import com.example.shipmentservice.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.example.shipmentservice.constant.GeneralConstant.LOCATION_NOT_FOUND;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public LocationServiceImpl(LocationRepository locationRepository, LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }

    @Override
    public List<Location> findAll(List<UUID> locationId) {
        return locationRepository.findAllById(locationId);
    }

    @Override
    public Location findById(UUID id) {
        return locationRepository.findById(id).orElseThrow(()-> new BusinessException(LOCATION_NOT_FOUND + id));
    }

    @Override
    public void add(CreateLocationDto createLocationDto) {
        Location location=locationMapper.createLocationFromCreatedLocationDto(createLocationDto);
        locationRepository.saveAndFlush(location);

    }

    @Override
    public List<LocationListiningDto> getAll() {
        List<Location> locations=locationRepository.findAll();
        return locations.stream().map(locationMapper::toLocationListiningDto).collect(Collectors.toList());
    }

    @Override
    public Location update(UpdateLocationDto updateLocationDto) {
        Location location =locationRepository.findById(updateLocationDto.getId()).orElseThrow(()->new BusinessException(LOCATION_NOT_FOUND));
        locationMapper.updateLocationFromUpdateLocationDto(updateLocationDto,location);
        return location;
    }

    @Override
    public void delete(DeleteLocationDto deleteLocationDto) {
        Location location=locationRepository.findById(deleteLocationDto.getId()).orElseThrow(()-> new BusinessException(LOCATION_NOT_FOUND));
        locationRepository.delete(location);
    }
}
