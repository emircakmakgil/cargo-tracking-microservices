package com.example.shipmentservice.data.dto.DeliveryReceipt;

import com.example.shipmentservice.model.enums.DeliveryStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DeliveryReceiptListiningDto {
    private LocalDateTime deliveredAt;
    private String receiverName;
    private String deliveryNotes;
    private DeliveryStatus deliveryStatus;

    public DeliveryReceiptListiningDto(LocalDateTime deliveredAt, String deliveryNotes, String receiverName, @NotNull(message = "Delivery status is required") DeliveryStatus deliveryStatus) {
        this.deliveredAt=deliveredAt;
        this.receiverName=receiverName;
        this.deliveryNotes=deliveryNotes;
        this.deliveryStatus=deliveryStatus;
    }
}
