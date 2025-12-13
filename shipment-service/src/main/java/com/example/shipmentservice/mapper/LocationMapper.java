package com.example.shipmentservice.mapper;

import com.example.shipmentservice.data.dto.LocationDto.CreateLocationDto;
import com.example.shipmentservice.data.dto.LocationDto.LocationListiningDto;
import com.example.shipmentservice.data.dto.LocationDto.UpdateLocationDto;
import com.example.shipmentservice.data.entity.Location;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class LocationMapper {
    public Location createLocationFromCreatedLocationDto(CreateLocationDto createLocationDto){
        return Location.builder().
                centerName(createLocationDto.getCenterName())
                .type(createLocationDto.getType())
                .build();
    }

    public void updateLocationFromUpdateLocationDto(UpdateLocationDto updateLocationDto,Location location){
        location.setCenterName(updateLocationDto.getCenterName());
        location.setType(updateLocationDto.getType());
        location.setUpdateDate(LocalDateTime.now());
    }

    public LocationListiningDto toLocationListiningDto(Location location){
        return new LocationListiningDto(
                location.getCenterName(),
                location.getType()
        );
    }
}
