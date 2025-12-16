package com.example.trackingservice.application.tracking.query.getList;

import an.awesome.pipelinr.Command;
import com.example.trackingservice.domain.entity.Tracking;
import com.example.trackingservice.persistence.tracking.TrackingRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;


public class GetListTrackingQuery implements Command<List<GetListTrackingDto>> {

    @Component
    @RequiredArgsConstructor
    public static class GetListTrackingQueryHandler implements Command.Handler<GetListTrackingQuery,List<GetListTrackingDto>>{

        private final TrackingRepository trackingRepository;

        @Override
        public List<GetListTrackingDto> handle(GetListTrackingQuery getListTrackingQuery) {
            List<Tracking> tracking=trackingRepository.findAll();

            return tracking.stream().map(tracking1 -> new GetListTrackingDto(tracking1.getStatus(),tracking1.getDescription(),tracking1.getEventTime())).toList();
        }
    }
}
