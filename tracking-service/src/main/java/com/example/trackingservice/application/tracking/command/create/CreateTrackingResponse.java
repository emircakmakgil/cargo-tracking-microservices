package com.example.trackingservice.application.tracking.command.create;


import com.example.trackingservice.model.enums.TrackingStatusCode;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTrackingResponse {
    private TrackingStatusCode status;
    private String description;

}
