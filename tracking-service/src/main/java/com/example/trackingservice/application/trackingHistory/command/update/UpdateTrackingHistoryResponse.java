package com.example.trackingservice.application.trackingHistory.command.update;

import com.example.trackingservice.model.enums.TrackingStatusCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class UpdateTrackingHistoryResponse {
    private UUID id;
    private TrackingStatusCode status;
    private String description;
}
