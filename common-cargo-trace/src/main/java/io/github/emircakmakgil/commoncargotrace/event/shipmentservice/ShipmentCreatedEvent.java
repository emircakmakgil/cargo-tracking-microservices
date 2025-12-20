package io.github.emircakmakgil.commoncargotrace.event.shipmentservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentCreatedEvent {
    private UUID id;
    private UUID senderId;
    private UUID receiverId;
    private UUID packageId;
    private String shipmentStatus;
    private LocalDateTime createAt;
    private String trackingNumber;
    private String serviceTypeCode;
    private String locationId;
}
