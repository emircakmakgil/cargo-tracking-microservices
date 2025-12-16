package com.example.trackingservice.application.location.command.update;

import com.example.trackingservice.model.enums.LocationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLocationResponse {
    private UUID id;
    private String name;
    private LocationType type;
    private String code;
    private String country;
    private String city;

}
