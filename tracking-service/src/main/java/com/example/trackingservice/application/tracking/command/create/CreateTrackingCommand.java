package com.example.trackingservice.application.tracking.command.create;

import an.awesome.pipelinr.Command;
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
public class CreateTrackingCommand implements Command<CreateTrackingResponse> {
    private TrackingStatusCode status;
    private String description;

    @Component
    @RequiredArgsConstructor
    public static class CreateTrackingCommandHandler implements Command.Handler<CreateTrackingCommand,CreateTrackingResponse>{
        private final TrackingRepository trackingRepository;
        @Override
        public CreateTrackingResponse handle(CreateTrackingCommand createTrackingCommand) {
            Tracking tracking=new Tracking();
            tracking.setDescription(createTrackingCommand.getDescription());
            tracking.setStatus(createTrackingCommand.getStatus());
            tracking.setEventTime(LocalDateTime.now());
            trackingRepository.save(tracking);
            return new CreateTrackingResponse(tracking.getStatus(),tracking.getDescription());
        }
    }
}
