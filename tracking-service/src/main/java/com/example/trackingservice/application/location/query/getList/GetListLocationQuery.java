package com.example.trackingservice.application.location.query.getList;

import an.awesome.pipelinr.Command;
import com.example.trackingservice.domain.entity.Location;
import com.example.trackingservice.persistence.location.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

public class GetListLocationQuery  implements Command<List<GetListLocationDto>> {

    @Component
    @RequiredArgsConstructor
    public  static class GetListLocationQueryHandler implements Command.Handler<GetListLocationQuery,List<GetListLocationDto>>{

        private final LocationRepository locationRepository;

        @Override
        public List<GetListLocationDto> handle(GetListLocationQuery getListLocationQuery) {
            List<Location> locations=locationRepository.findAll();

            return locations.stream().map(location -> new GetListLocationDto(location.getName(),location.getType(),location.getCity(),location.getCountry())).toList();
        }
    }

}
