package com.example.trackingservice.application.tracking.command.update;

import an.awesome.pipelinr.Command;
import com.example.trackingservice.domain.entity.Tracking;
import com.example.trackingservice.model.enums.TrackingStatusCode;
import com.example.trackingservice.persistence.tracking.TrackingRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class UpdateTrackingCommand implements Command<UpdateTrackingResponse> {
    private UUID id;
    private TrackingStatusCode status;
    private String description;

    @Component
    @RequiredArgsConstructor
    public static class UpdateTrackingCommandHandler implements Command.Handler<UpdateTrackingCommand,UpdateTrackingResponse>{

        private final TrackingRepository trackingRepository;

        @Override
        public UpdateTrackingResponse handle(UpdateTrackingCommand updateTrackingCommand) {
            Tracking tracking=trackingRepository.findById(updateTrackingCommand.getId()).orElseThrow(()-> new RuntimeException("Gönderi bulunamadı"));
            tracking.setEventTime(LocalDateTime.now());
            tracking.setDescription(updateTrackingCommand.getDescription());
            tracking.setStatus(updateTrackingCommand.getStatus());
            return new UpdateTrackingResponse(tracking.getId(),tracking.getStatus(),tracking.getDescription());
        }
    }
}
