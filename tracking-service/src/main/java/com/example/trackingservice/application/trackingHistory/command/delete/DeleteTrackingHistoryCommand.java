package com.example.trackingservice.application.trackingHistory.command.delete;

import an.awesome.pipelinr.Command;
import com.example.trackingservice.application.tracking.command.delete.DeleteTrackingCommand;
import com.example.trackingservice.application.tracking.command.delete.DeleteTrackingResponse;
import com.example.trackingservice.domain.entity.Tracking;
import com.example.trackingservice.persistence.tracking.TrackingRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
public class DeleteTrackingHistoryCommand implements Command<DeleteTrackingHistoryResponse> {
    private UUID id;

    @Component
    @RequiredArgsConstructor
    public static class DeleteTrackingHistoryCommandHandler implements Command.Handler<DeleteTrackingHistoryCommand, DeleteTrackingHistoryResponse>{

        private final TrackingRepository trackingRepository;
        @Override
        public DeleteTrackingHistoryResponse handle(DeleteTrackingHistoryCommand deleteTrackingHistoryCommand) {
            Tracking tracking=trackingRepository.findById(deleteTrackingHistoryCommand.getId()).orElseThrow(()-> new RuntimeException("Gönderi bulunamadı"));
            trackingRepository.delete(tracking);

            return new DeleteTrackingHistoryResponse(tracking.getId());
        }
    }
}
