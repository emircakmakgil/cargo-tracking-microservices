package com.example.shipmentservice.data.dto.ShipmentDto;

import com.example.shipmentservice.model.enums.ShipmentLifecycleStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ShipmentListiningDto {
    private String trackingNumber;
    private ShipmentLifecycleStatus shipmentLifecycleStatus;
    private LocalDateTime estimateDeliveryDate;
    private Boolean isPaid = Boolean.FALSE;
    private UUID receiverContactId;

    public ShipmentListiningDto(@NotBlank(message = "Tracking number is required") @Size(max = 50, message = "Tracking number must be max 50 characters") String trackingNumber, @NotNull(message = "Status code is required") ShipmentLifecycleStatus shipmentLifecycleStatus, LocalDateTime estimateDeliveryDate, Boolean isPaid) {
        this.trackingNumber=trackingNumber;
        this.shipmentLifecycleStatus = shipmentLifecycleStatus;
        this.estimateDeliveryDate=estimateDeliveryDate;
        this.isPaid=isPaid;
    }
}
