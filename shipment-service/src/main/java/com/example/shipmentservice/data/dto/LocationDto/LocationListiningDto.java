package com.example.shipmentservice.data.dto.LocationDto;

import com.example.shipmentservice.model.enums.LocationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationListiningDto {

    private String centerName;
    private LocationType type;

    public LocationListiningDto(@NotBlank(message = "Center name is required") @Size(max = 200, message = "Center name must be max 200 characters") String centerName, @NotNull(message = "Location type is required") LocationType type) {
        this.centerName=centerName;
        this.type=type;
    }
}
