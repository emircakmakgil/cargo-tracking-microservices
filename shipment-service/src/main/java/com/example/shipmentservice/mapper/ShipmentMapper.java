package com.example.shipmentservice.mapper;

import com.example.shipmentservice.data.dto.ShipmentDto.ReceiverDto.CreateReceiverShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.ReceiverDto.ReceiverShipmentListiningDto;
import com.example.shipmentservice.data.dto.ShipmentDto.ReceiverDto.UpdateReceiverShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.SenderDto.CreateSenderShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.SenderDto.SenderShipmentListiningDto;
import com.example.shipmentservice.data.dto.ShipmentDto.SenderDto.UpdateSenderShipmentDto;
import com.example.shipmentservice.data.entity.Shipments;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ShipmentMapper {
    public Shipments createReceiverShipmentFromCreateReceiverShipmentDto(CreateReceiverShipmentDto createReceiverShipmentDto){
        return Shipments.builder()
                .trackingNumber(createReceiverShipmentDto.getTrackingNumber())
                .statusCode(createReceiverShipmentDto.getStatusCode())
                .estimateDeliveryDate(createReceiverShipmentDto.getEstimateDeliveryDate())
                .isPaid(createReceiverShipmentDto.getIsPaid())
                  .build();
    }

    public void updateReceiverShipmentFromUpdateReceiverShipmentDto(UpdateReceiverShipmentDto updateReceiverShipmentDto,Shipments shipments){
        shipments.setTrackingNumber(updateReceiverShipmentDto.getTrackingNumber());
        shipments.setStatusCode(updateReceiverShipmentDto.getStatusCode());
        shipments.setEstimateDeliveryDate(updateReceiverShipmentDto.getEstimateDeliveryDate());
        shipments.setEstimateDeliveryDate(updateReceiverShipmentDto.getEstimateDeliveryDate());
        shipments.setIsPaid(updateReceiverShipmentDto.getIsPaid());
    }

    public ReceiverShipmentListiningDto toReceiverShipmentListiningDto(Shipments shipments){
        return new ReceiverShipmentListiningDto(
                shipments.getTrackingNumber(),
                shipments.getStatusCode(),
                shipments.getEstimateDeliveryDate(),
                shipments.getIsPaid()
        );
    }
    public Shipments createSenderShipmentFromCreateReceiverShipmentDto(CreateSenderShipmentDto createSenderShipmentDto){
        return Shipments.builder()
                .trackingNumber(createSenderShipmentDto.getTrackingNumber())
                .statusCode(createSenderShipmentDto.getStatusCode())
                .estimateDeliveryDate(createSenderShipmentDto.getEstimateDeliveryDate())
                .isPaid(createSenderShipmentDto.getIsPaid())
                .build();
    }

    public void updateSenderShipmentFromUpdateReceiverShipmentDto(UpdateSenderShipmentDto updateSenderShipmentDto, Shipments shipments){
        shipments.setTrackingNumber(updateSenderShipmentDto.getTrackingNumber());
        shipments.setStatusCode(updateSenderShipmentDto.getStatusCode());
        shipments.setEstimateDeliveryDate(updateSenderShipmentDto.getEstimateDeliveryDate());
        shipments.setEstimateDeliveryDate(updateSenderShipmentDto.getEstimateDeliveryDate());
        shipments.setIsPaid(updateSenderShipmentDto.getIsPaid());
    }

    public SenderShipmentListiningDto toSenderShipmentListiningDto(Shipments shipments){
        return new SenderShipmentListiningDto(
                shipments.getTrackingNumber(),
                shipments.getStatusCode(),
                shipments.getEstimateDeliveryDate(),
                shipments.getIsPaid()
        );
    }
}
