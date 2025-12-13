package com.example.shipmentservice.data.dto.DeliveryReceipt;

import com.example.shipmentservice.model.enums.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class UpdateDeliveryReceiptDto {
    private UUID id;
    private LocalDateTime deliveredAt;
    private String receiverName;
    private String signatureImageUrl;
    private String deliveryNotes;
    private DeliveryStatus deliveryStatus;
    private LocalDateTime updateAt;
}
