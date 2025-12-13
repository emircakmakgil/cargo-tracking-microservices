package com.example.shipmentservice.data.dto.ShipmentDto.ReceiverDto;

import com.example.shipmentservice.model.enums.StatusCode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ReceiverShipmentListiningDto {
    private String trackingNumber;
    private StatusCode statusCode;
    private LocalDateTime estimateDeliveryDate;
    private Boolean isPaid = Boolean.FALSE;
    private UUID receiverContactId;

    public ReceiverShipmentListiningDto(@NotBlank(message = "Tracking number is required") @Size(max = 50, message = "Tracking number must be max 50 characters") String trackingNumber, @NotNull(message = "Status code is required") StatusCode statusCode, LocalDateTime estimateDeliveryDate, Boolean isPaid) {
        this.trackingNumber=trackingNumber;
        this.statusCode=statusCode;
        this.estimateDeliveryDate=estimateDeliveryDate;
        this.isPaid=isPaid;
    }
}
