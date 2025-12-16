package com.example.shipmentservice.mapper;

import com.example.shipmentservice.data.dto.ShipmentDto.CreateShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.ShipmentListiningDto;
import com.example.shipmentservice.data.dto.ShipmentDto.UpdateShipmentDto;
import com.example.shipmentservice.data.entity.Shipments;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ShipmentMapper {
    public Shipments createShipmentFromCreateReceiverShipmentDto(CreateShipmentDto createShipmentDto){
        return Shipments.builder()
                .trackingNumber(createShipmentDto.getTrackingNumber())
                .shipmentLifecycleStatus(createShipmentDto.getShipmentLifecycleStatus())
                .estimateDeliveryDate(createShipmentDto.getEstimateDeliveryDate())
                .isPaid(createShipmentDto.getIsPaid())
                  .build();
    }

    public void updateShipmentFromUpdateReceiverShipmentDto(UpdateShipmentDto updateShipmentDto, Shipments shipments){
        shipments.setTrackingNumber(updateShipmentDto.getTrackingNumber());
        shipments.setShipmentLifecycleStatus(updateShipmentDto.getShipmentLifecycleStatus());
        shipments.setEstimateDeliveryDate(updateShipmentDto.getEstimateDeliveryDate());
        shipments.setEstimateDeliveryDate(updateShipmentDto.getEstimateDeliveryDate());
        shipments.setIsPaid(updateShipmentDto.getIsPaid());
    }

    public ShipmentListiningDto toShipmentListiningDto(Shipments shipments){
        return new ShipmentListiningDto(
                shipments.getTrackingNumber(),
                shipments.getShipmentLifecycleStatus(),
                shipments.getEstimateDeliveryDate(),
                shipments.getIsPaid()
        );
    }
}
