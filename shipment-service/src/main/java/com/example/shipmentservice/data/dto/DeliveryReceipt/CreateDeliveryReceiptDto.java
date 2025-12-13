package com.example.shipmentservice.data.dto.DeliveryReceipt;

import com.example.shipmentservice.model.enums.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateDeliveryReceiptDto {

    private LocalDateTime deliveredAt;
    private String receiverName;
    private String signatureImageUrl;
    private String deliveryNotes;
    private DeliveryStatus deliveryStatus;
}
