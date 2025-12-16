package com.example.shipmentservice.data.dto.ShipmentDto;

import com.example.shipmentservice.model.enums.ShipmentLifecycleStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class UpdateShipmentDto {
    private UUID id;
    private String trackingNumber;
    private ShipmentLifecycleStatus shipmentLifecycleStatus;
    private LocalDateTime estimateDeliveryDate;

    private UUID senderContactId;
    private UUID receiverContactId;

    private Boolean isPaid = Boolean.FALSE;

    private UUID serviceTypeId;
    private UUID locationId;
    private UUID deliveryReceiptId;
    private UUID contractId;
    private UUID packageId;


}
