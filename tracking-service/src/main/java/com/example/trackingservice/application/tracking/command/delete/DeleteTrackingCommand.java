package com.example.trackingservice.application.tracking.command.delete;


import an.awesome.pipelinr.Command;
import com.example.trackingservice.domain.entity.Tracking;
import com.example.trackingservice.persistence.tracking.TrackingRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
public class DeleteTrackingCommand implements Command<DeleteTrackingResponse> {
    private UUID id;
    @Component
    @RequiredArgsConstructor
    public static class DeleteTrackingCommandHandler implements Command.Handler<DeleteTrackingCommand,DeleteTrackingResponse>{

        private final TrackingRepository trackingRepository;
        @Override
        public DeleteTrackingResponse handle(DeleteTrackingCommand deleteTrackingCommand) {
            Tracking tracking=trackingRepository.findById(deleteTrackingCommand.getId()).orElseThrow(()-> new RuntimeException("Gönderi bulunamadı"));
            trackingRepository.delete(tracking);

            return new DeleteTrackingResponse(tracking.getId());
        }
    }
}
