package com.example.trackingservice.application.location.command.create;


import com.example.trackingservice.model.enums.LocationType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateLocationResponse {
    private String name;
    private LocationType type;
    private String city;
    private String country;

}
