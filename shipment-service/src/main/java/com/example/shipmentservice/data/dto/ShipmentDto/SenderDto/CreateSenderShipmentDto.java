package com.example.shipmentservice.data.dto.ShipmentDto.SenderDto;

import com.example.shipmentservice.model.enums.StatusCode;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class CreateSenderShipmentDto {
    
    private String trackingNumber;
    
    private StatusCode statusCode;
    
    private LocalDateTime estimateDeliveryDate;

    private UUID senderContactId;
    private UUID deliveryReceiptId;
    private UUID serviceTypeId;
    private UUID locationId;
    private Boolean isPaid = Boolean.FALSE;
    private UUID packageId;
}
