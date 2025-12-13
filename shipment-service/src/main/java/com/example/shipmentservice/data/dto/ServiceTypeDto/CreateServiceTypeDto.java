package com.example.shipmentservice.data.dto.ServiceTypeDto;

import com.example.shipmentservice.model.enums.DeliverySlaType;
import com.example.shipmentservice.model.enums.ServiceTypeName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateServiceTypeDto {
    private ServiceTypeName serviceTypeName;
    private Double basePrice;
    private DeliverySlaType deliverySlaType;
    private String description;
    private Double minWeight;
    private Double maxWeight;
    private Double maxLength;
    private Double maxWidth;
    private Double maxHeight;
    private Boolean active = true;
    private Double additionalFee;
}

