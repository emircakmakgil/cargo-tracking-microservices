package com.example.shipmentservice.data.dto.LocationDto;

import com.example.shipmentservice.model.enums.LocationType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class UpdateLocationDto {
    private UUID id;
    private String centerName;
    private LocationType type;
    private LocalDateTime updateAt;
}
