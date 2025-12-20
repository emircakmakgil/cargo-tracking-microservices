package com.example.trackingservice.application.trackingHistory.command.create;

import com.example.trackingservice.model.enums.TrackingStatusCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTrackingHistoryResponse {
    private TrackingStatusCode status;
    private String description;
}
