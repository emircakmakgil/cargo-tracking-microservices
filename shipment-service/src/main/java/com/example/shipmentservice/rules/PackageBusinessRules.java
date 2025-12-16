package com.example.shipmentservice.rules;

import com.example.shipmentservice.core.exception.type.BusinessException;
import com.example.shipmentservice.data.entity.Package;
import com.example.shipmentservice.model.enums.PackageType;
import org.springframework.stereotype.Component;

import static com.example.shipmentservice.constant.GeneralConstant.*;

@Component
public class PackageBusinessRules {

    public void checkPackageExists(Package packages) {
        if (packages == null) {
            throw new BusinessException(PACKAGE_NOT_FOUND);
        }
    }

    public void checkRequiredFields(
            Double weight,
            Double length,
            Double width,
            Double height,
            PackageType packageType) {

        if (weight == null) {
            throw new BusinessException(PACKAGE_WEIGHT_REQUIRED);
        }
        if (length == null || width == null || height == null) {
            throw new BusinessException(PACKAGE_DIMENSIONS_REQUIRED);
        }
        if (packageType == null) {
            throw new BusinessException(PACKAGE_TYPE_REQUIRED);
        }
    }

    public void checkPositiveAndLimit(Double weight, Double length, Double width, Double height) {

        boolean negativeOrZero = (weight != null && weight <= 0)
                || (length != null && length <= 0)
                || (width != null && width <= 0)
                || (height != null && height <= 0);

        if (negativeOrZero) {
            throw new BusinessException(PACKAGE_DIMENSIONS_POSITIVE);
        }

        if (weight != null && weight > 1000) {
            throw new BusinessException(PACKAGE_WEIGHT_TOO_HIGH);
        }
    }
}