package com.example.trackingservice.application.location.command.create;

import an.awesome.pipelinr.Command;
import com.example.trackingservice.domain.entity.Location;
import com.example.trackingservice.model.enums.LocationType;
import com.example.trackingservice.persistence.location.LocationRepository;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateLocationCommand implements Command<CreateLocationResponse> {
    private String name;
    private LocationType type;
    private String code;
    private String country;
    private String city;

    @Component
    @RequiredArgsConstructor
    public static class CreateLocationCommandHandler implements Command.Handler<CreateLocationCommand,CreateLocationResponse>
    {
        private final LocationRepository locationRepository;

        @Override
        public CreateLocationResponse handle(CreateLocationCommand createLocationCommand) {
            Location location=new Location();
            location.setName(createLocationCommand.getName());
            location.setType(createLocationCommand.getType());
            location.setCode(createLocationCommand.getCode());
            location.setCity(createLocationCommand.getCity());
            location.setCountry(createLocationCommand.getCountry());
            locationRepository.saveAndFlush(location);

            return new CreateLocationResponse(location.getName(),location.getType(),location.getCity(),location.getCountry());
        }
    }
}
