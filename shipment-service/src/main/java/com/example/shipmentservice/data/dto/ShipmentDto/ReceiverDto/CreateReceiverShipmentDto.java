package com.example.shipmentservice.data.dto.ShipmentDto.ReceiverDto;

import com.example.shipmentservice.model.enums.StatusCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class CreateReceiverShipmentDto {
    
    private String trackingNumber;
    
    private StatusCode statusCode;
    
    private LocalDateTime estimateDeliveryDate;


    private UUID receiverContactId;

    private UUID serviceTypeId;

    private UUID locationId;
    private UUID deliveryReceiptId;


    private Boolean isPaid = Boolean.FALSE;

    
    private UUID packageId;
}


