package com.example.trackingservice.application.trackingHistory.command.delete;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteTrackingHistoryResponse {
    private UUID id;
}
