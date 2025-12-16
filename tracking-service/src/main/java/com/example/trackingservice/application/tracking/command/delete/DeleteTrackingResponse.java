package com.example.trackingservice.application.tracking.command.delete;

import an.awesome.pipelinr.repack.org.checkerframework.checker.units.qual.A;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteTrackingResponse {
    private UUID id;
}
