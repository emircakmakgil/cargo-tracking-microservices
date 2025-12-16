package com.example.trackingservice.application.tracking.command.update;

import com.example.trackingservice.model.enums.TrackingStatusCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTrackingResponse {
    private UUID id;
    private TrackingStatusCode status;
    private String description;
}
