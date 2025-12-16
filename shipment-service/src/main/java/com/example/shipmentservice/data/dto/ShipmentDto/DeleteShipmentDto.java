package com.example.shipmentservice.data.dto.ShipmentDto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DeleteShipmentDto {
    private UUID id;
    private UUID receiverContactId;
}
