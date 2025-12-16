package com.example.trackingservice.application.location.query.getList;

import com.example.trackingservice.model.enums.LocationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetListLocationDto {
    private String name;
    private LocationType type;
    private String city;
    private String country;




}
