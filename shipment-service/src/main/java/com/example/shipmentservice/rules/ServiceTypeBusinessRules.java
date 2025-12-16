package com.example.shipmentservice.rules;

import com.example.shipmentservice.core.exception.type.BusinessException;
import com.example.shipmentservice.data.entity.ServiceType;
import com.example.shipmentservice.model.enums.DeliverySlaType;
import com.example.shipmentservice.model.enums.ServiceTypeName;
import org.springframework.stereotype.Component;

import static com.example.shipmentservice.constant.GeneralConstant.*;

@Component
public class ServiceTypeBusinessRules {

    public void checkServiceTypeExists(ServiceType serviceType) {
        if (serviceType == null) {
            throw new BusinessException(SERVICE_TYPE_NOT_FOUND);
        }
    }

    public void checkRequiredFields(ServiceTypeName serviceTypeName, Double basePrice, DeliverySlaType deliverySlaType) {
        if (serviceTypeName == null) {
            throw new BusinessException(SERVICE_TYPE_NAME_REQUIRED);
        }
        if (basePrice == null) {
            throw new BusinessException(SERVICE_TYPE_BASE_PRICE_REQUIRED);
        }
        if (deliverySlaType == null) {
            throw new BusinessException(SERVICE_TYPE_DELIVERY_SLA_REQUIRED);
        }
    }

    public void checkPriceAndFees(Double basePrice, Double additionalFee) {
        if (basePrice != null && basePrice <= 0) {
            throw new BusinessException(SERVICE_TYPE_BASE_PRICE_POSITIVE);
        }
        if (additionalFee != null && additionalFee < 0) {
            throw new BusinessException(SERVICE_TYPE_ADDITIONAL_FEE_NEGATIVE);
        }
    }

    public void checkWeightAndDimensionLimits(
            Double minWeight,
            Double maxWeight,
            Double maxLength,
            Double maxWidth,
            Double maxHeight) {

        boolean negativeOrZero =
                (minWeight != null && minWeight <= 0)
                        || (maxWeight != null && maxWeight <= 0)
                        || (maxLength != null && maxLength <= 0)
                        || (maxWidth != null && maxWidth <= 0)
                        || (maxHeight != null && maxHeight <= 0);

        if (negativeOrZero) {
            throw new BusinessException(SERVICE_TYPE_DIMENSIONS_POSITIVE);
        }

        if (minWeight != null && maxWeight != null && maxWeight < minWeight) {
            throw new BusinessException(SERVICE_TYPE_WEIGHT_RANGE_INVALID);
        }
    }
}
