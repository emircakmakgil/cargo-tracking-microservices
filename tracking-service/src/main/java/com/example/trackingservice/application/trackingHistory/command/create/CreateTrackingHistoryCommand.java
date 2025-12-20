package com.example.trackingservice.application.trackingHistory.command.create;

import an.awesome.pipelinr.Command;
import com.example.trackingservice.application.tracking.command.create.CreateTrackingCommand;
import com.example.trackingservice.application.tracking.command.create.CreateTrackingResponse;
import com.example.trackingservice.domain.entity.Tracking;
import com.example.trackingservice.model.enums.TrackingStatusCode;
import com.example.trackingservice.persistence.tracking.TrackingRepository;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTrackingHistoryCommand implements Command<CreateTrackingHistoryResponse>{

    private TrackingStatusCode status;
    private String description;

    @Component
    @RequiredArgsConstructor
    public static class CreateTrackingHistoryCommandHandler implements Command.Handler<CreateTrackingHistoryCommand, CreateTrackingHistoryResponse>{
        private final TrackingRepository trackingRepository;
        @Override
        public CreateTrackingHistoryResponse handle(CreateTrackingHistoryCommand createTrackingHistoryCommand) {
            Tracking tracking=new Tracking();
            tracking.setDescription(createTrackingHistoryCommand.getDescription());
            tracking.setStatus(createTrackingHistoryCommand.getStatus());
            tracking.setEventTime(LocalDateTime.now());
            trackingRepository.save(tracking);
            return new CreateTrackingHistoryResponse(tracking.getStatus(),tracking.getDescription());
        }
    }
}
