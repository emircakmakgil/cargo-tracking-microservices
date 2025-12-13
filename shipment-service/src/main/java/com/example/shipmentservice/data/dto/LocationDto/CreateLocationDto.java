package com.example.shipmentservice.data.dto.LocationDto;

import com.example.shipmentservice.model.enums.LocationType;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateLocationDto {
    private String centerName;
    private LocationType type;
}
