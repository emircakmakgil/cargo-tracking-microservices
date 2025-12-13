package com.example.shipmentservice.data.dto.ServiceTypeDto;

import com.example.shipmentservice.model.enums.DeliverySlaType;
import com.example.shipmentservice.model.enums.ServiceTypeName;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceTypeListiningDto {
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

    public ServiceTypeListiningDto(@NotNull(message = "Service type name is required") ServiceTypeName serviceTypeName, @NotNull(message = "Base price is required") @Min(value = 0, message = "Base price must be positive") Double basePrice, DeliverySlaType deliverySlaType, String description, String description1, Double minWeight, Double maxWeight, Double maxLength, Double maxWidth, Double maxHeight, Boolean active, Double additionalFee) {
        this.serviceTypeName=serviceTypeName;
        this.basePrice=basePrice;
        this.deliverySlaType=deliverySlaType;
        this.description=description;
        this.minWeight=minWeight;
        this.maxWeight=maxWeight;
        this.maxLength=maxLength;
        this.maxWidth=maxWidth;
        this.maxHeight=maxHeight;
        this.active=active;
        this.additionalFee=additionalFee;
    }
}
