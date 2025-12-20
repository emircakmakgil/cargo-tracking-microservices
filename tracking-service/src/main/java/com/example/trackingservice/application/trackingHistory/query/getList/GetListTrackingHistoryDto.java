package com.example.trackingservice.application.trackingHistory.query.getList;

import com.example.trackingservice.model.enums.TrackingStatusCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetListTrackingHistoryDto {
    private TrackingStatusCode status;
    private String description;
    private LocalDateTime eventTime;
}
