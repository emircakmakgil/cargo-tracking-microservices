package com.example.shipmentservice.data.dto.ShipmentDto.ReceiverDto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DeleteReceiverShipmentDto {
    private UUID id;
    private UUID receiverContactId;
}
