package com.example.trackingservice.application.trackingHistory.command.update;

import an.awesome.pipelinr.Command;
import com.example.trackingservice.application.tracking.command.update.UpdateTrackingCommand;
import com.example.trackingservice.application.tracking.command.update.UpdateTrackingResponse;
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
public class UpdateTrackingHistoryCommand implements Command<UpdateTrackingHistoryResponse> {
    private UUID id;
    private TrackingStatusCode status;
    private String description;



    @Component
    @RequiredArgsConstructor
    public static class UpdateTrackingHistoryCommandHandler implements Command.Handler<UpdateTrackingHistoryCommand, UpdateTrackingHistoryResponse>{

        private final TrackingRepository trackingRepository;

        @Override
        public UpdateTrackingHistoryResponse handle(UpdateTrackingHistoryCommand updateTrackingHistoryCommand) {
            Tracking tracking=trackingRepository.findById(updateTrackingHistoryCommand.getId()).orElseThrow(()-> new RuntimeException("Gönderi bulunamadı"));
            tracking.setEventTime(LocalDateTime.now());
            tracking.setDescription(updateTrackingHistoryCommand.getDescription());
            tracking.setStatus(updateTrackingHistoryCommand.getStatus());
            return new UpdateTrackingHistoryResponse(tracking.getId(),tracking.getStatus(),tracking.getDescription());
        }
    }
}
