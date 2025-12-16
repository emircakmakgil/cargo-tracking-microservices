package com.example.shipmentservice.rules;

import com.example.shipmentservice.core.exception.type.BusinessException;
import com.example.shipmentservice.data.entity.Location;
import com.example.shipmentservice.model.enums.LocationType;
import org.springframework.stereotype.Component;

import static com.example.shipmentservice.constant.GeneralConstant.*;

@Component
public class LocationBusinessRules {

    public void checkLocationExists(Location location) {
        if (location == null) {
            throw new BusinessException(LOCATION_NOT_FOUND);
        }
    }

    public void checkRequiredFields(String centerName, LocationType type) {
        if (centerName == null || centerName.isBlank()) {
            throw new BusinessException(LOCATION_CENTER_NAME_REQUIRED);
        }
        if (centerName.length() > 200) {
            throw new BusinessException(LOCATION_CENTER_NAME_TOO_LONG);
        }
        if (type == null) {
            throw new BusinessException(LOCATION_TYPE_REQUIRED);
        }
    }
}
