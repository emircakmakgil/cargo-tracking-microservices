package com.example.shipmentservice.data.dto.ShipmentDto.SenderDto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DeleteSenderShipmentDto {
    private UUID id;
    private UUID senderContactId;

}
