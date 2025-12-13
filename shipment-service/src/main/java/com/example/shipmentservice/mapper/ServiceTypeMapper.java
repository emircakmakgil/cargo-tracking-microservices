package com.example.shipmentservice.mapper;

import com.example.shipmentservice.data.dto.ServiceTypeDto.CreateServiceTypeDto;
import com.example.shipmentservice.data.dto.ServiceTypeDto.ServiceTypeListiningDto;
import com.example.shipmentservice.data.dto.ServiceTypeDto.UpdateServiceTypeDto;
import com.example.shipmentservice.data.entity.ServiceType;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ServiceTypeMapper {
    public ServiceType createServiceTypeFromCreatedServiceType(CreateServiceTypeDto createServiceTypeDto){
        return ServiceType.builder()
                .serviceTypeName(createServiceTypeDto.getServiceTypeName())
                .basePrice(createServiceTypeDto.getBasePrice())
                .deliverySlaType(createServiceTypeDto.getDeliverySlaType())
                .description(createServiceTypeDto.getDescription())
                .minWeight(createServiceTypeDto.getMinWeight())
                .maxWeight(createServiceTypeDto.getMaxWeight())
                .maxLength(createServiceTypeDto.getMaxLength())
                .maxWidth(createServiceTypeDto.getMaxWidth())
                .maxHeight(createServiceTypeDto.getMaxHeight())
                .active(createServiceTypeDto.getActive())
                .additionalFee(createServiceTypeDto.getAdditionalFee())
                .build();
    }

    public void updateServiceTypeFromUpdatedServiceTypeDto(UpdateServiceTypeDto updateServiceTypeDto,ServiceType serviceType){
        serviceType.setServiceTypeName(updateServiceTypeDto.getServiceTypeName());
        serviceType.setBasePrice(updateServiceTypeDto.getBasePrice());
        serviceType.setDeliverySlaType(updateServiceTypeDto.getDeliverySlaType());
        serviceType.setDescription(updateServiceTypeDto.getDescription());
        serviceType.setMinWeight(updateServiceTypeDto.getMinWeight());
        serviceType.setMaxWeight(updateServiceTypeDto.getMaxWeight());
        serviceType.setMaxLength(updateServiceTypeDto.getMaxLength());
        serviceType.setMaxWidth(updateServiceTypeDto.getMaxWidth());
        serviceType.setMaxHeight(updateServiceTypeDto.getMaxHeight());
        serviceType.setActive(updateServiceTypeDto.getActive());
        serviceType.setAdditionalFee(updateServiceTypeDto.getAdditionalFee());
    }

    public ServiceTypeListiningDto toServiceTypeListiningDto(ServiceType serviceType){
        return new ServiceTypeListiningDto(
                serviceType.getServiceTypeName(),
                serviceType.getBasePrice(),
                serviceType.getDeliverySlaType(),
                serviceType.getDescription(),
                serviceType.getDescription(),
                serviceType.getMinWeight(),
                serviceType.getMaxWeight(),
                serviceType.getMaxLength(),
                serviceType.getMaxWidth(),
                serviceType.getMaxHeight(),
                serviceType.getActive(),
                serviceType.getAdditionalFee()
        );
    }

}
