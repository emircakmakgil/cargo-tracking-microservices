package com.example.shipmentservice.mapper;

import com.example.shipmentservice.data.dto.DeliveryReceipt.CreateDeliveryReceiptDto;
import com.example.shipmentservice.data.dto.DeliveryReceipt.DeliveryReceiptListiningDto;
import com.example.shipmentservice.data.dto.DeliveryReceipt.UpdateDeliveryReceiptDto;
import com.example.shipmentservice.data.entity.DeliveryReceipt;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class DeliveryReceiptMapper {
    public DeliveryReceipt createDeliveryReceiptFromCreateDeliveryReceipt(CreateDeliveryReceiptDto createDeliveryReceiptDto){
        return DeliveryReceipt.builder()
                .deliveredAt(createDeliveryReceiptDto.getDeliveredAt())
                .receiverName(createDeliveryReceiptDto.getReceiverName())
                .signatureImageUrl(createDeliveryReceiptDto.getSignatureImageUrl())
                .deliveryNotes(createDeliveryReceiptDto.getDeliveryNotes())
                .deliveryStatus(createDeliveryReceiptDto.getDeliveryStatus())
                .build();
    }

    public void updateDeliveryReceiptFromUpdateDeliveryReceiptDto(UpdateDeliveryReceiptDto updateDeliveryReceiptDto,DeliveryReceipt deliveryReceipt){
        deliveryReceipt.setDeliveredAt(updateDeliveryReceiptDto.getDeliveredAt());
        deliveryReceipt.setReceiverName(updateDeliveryReceiptDto.getReceiverName());
        deliveryReceipt.setSignatureImageUrl(updateDeliveryReceiptDto.getSignatureImageUrl());
        deliveryReceipt.setDeliveryNotes(updateDeliveryReceiptDto.getDeliveryNotes());
        deliveryReceipt.setDeliveryStatus(updateDeliveryReceiptDto.getDeliveryStatus());
    }

    public DeliveryReceiptListiningDto toDeliveryReceiptDto(DeliveryReceipt deliveryReceipt){
       return new DeliveryReceiptListiningDto(
        deliveryReceipt.getDeliveredAt(),
        deliveryReceipt.getDeliveryNotes(),
        deliveryReceipt.getReceiverName(),
        deliveryReceipt.getDeliveryStatus()
        );
    }
}
