package com.example.shipmentservice.data.dto.ShipmentDto.SenderDto;

import com.example.shipmentservice.model.enums.StatusCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class UpdateSenderShipmentDto {
    private UUID id;
    private String trackingNumber;
    private StatusCode statusCode;
    private LocalDateTime estimateDeliveryDate;

    private UUID senderContactId;

    private Boolean isPaid = Boolean.FALSE;

    private UUID serviceTypeId;
    private UUID locationId;
    private UUID deliveryReceiptId;
    private UUID packageId;
}
