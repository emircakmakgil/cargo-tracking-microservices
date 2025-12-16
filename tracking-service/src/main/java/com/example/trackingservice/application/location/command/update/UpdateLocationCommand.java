package com.example.trackingservice.application.location.command.update;

import an.awesome.pipelinr.Command;
import com.example.trackingservice.domain.entity.Location;
import com.example.trackingservice.model.enums.LocationType;
import com.example.trackingservice.persistence.location.LocationRepository;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLocationCommand implements Command<UpdateLocationResponse> {
    private UUID id;
    private String name;
    private LocationType type;
    private String code;
    private String country;
    private String city;

    @Component
    @RequiredArgsConstructor
    public  static class UpdateLocationHandler implements Command.Handler<UpdateLocationCommand,UpdateLocationResponse>{
        private LocationRepository locationRepository;

        @Override
        public UpdateLocationResponse handle(UpdateLocationCommand updateLocationCommand) {
            Location location=locationRepository.findById(updateLocationCommand.id).orElseThrow(()-> new RuntimeException("Lokasyon bulunamadı "));
            location.setName(updateLocationCommand.getName());
            location.setType(updateLocationCommand.getType());
            location.setCode(updateLocationCommand.getCode());
            location.setCity(updateLocationCommand.getCity());
            location.setCountry(updateLocationCommand.getCountry());
            locationRepository.saveAndFlush(location);
            return new UpdateLocationResponse(location.getId(),location.getName(),location.getType(),location.getCode(),location.getCountry(),location.getCity());

        }
    }
}
