package com.example.shipmentservice.data.dto.ShipmentDto;

import com.example.shipmentservice.model.enums.ShipmentLifecycleStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class CreateShipmentDto {
    
    private String trackingNumber;
    
    private ShipmentLifecycleStatus shipmentLifecycleStatus;
    
    private LocalDateTime estimateDeliveryDate;


    private UUID receiverContactId;
    private UUID senderContactId;


    private UUID serviceTypeId;

    private UUID locationId;
    private UUID deliveryReceiptId;


    private Boolean isPaid = Boolean.FALSE;

    
    private UUID packageId;
}


