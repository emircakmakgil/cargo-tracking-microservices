package com.example.trackingservice.application.location.command.delete;

import an.awesome.pipelinr.Command;
import com.example.trackingservice.domain.entity.Location;
import com.example.trackingservice.persistence.location.LocationRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
public class DeleteLocationCommand implements Command<DeleteLocationResponse> {
    private UUID id;

    @Component
    @RequiredArgsConstructor
    public static class DeleteLocationCommandHandler implements Command.Handler<DeleteLocationCommand,DeleteLocationResponse>{

        private LocationRepository locationRepository;
        @Override
        public DeleteLocationResponse handle(DeleteLocationCommand deleteLocationCommand) {
            Location location =locationRepository.findById(deleteLocationCommand.getId()).orElseThrow(()-> new RuntimeException("Lokasyon bulunamadı."));
            locationRepository.delete(location);
            return new DeleteLocationResponse(location.getId());
        }
    }

}
