package com.example.trackingservice.controller;

import an.awesome.pipelinr.Pipeline;
import com.example.trackingservice.application.location.command.create.CreateLocationCommand;
import com.example.trackingservice.application.location.command.create.CreateLocationResponse;
import com.example.trackingservice.application.location.command.delete.DeleteLocationCommand;
import com.example.trackingservice.application.location.command.delete.DeleteLocationResponse;
import com.example.trackingservice.application.location.command.update.UpdateLocationCommand;
import com.example.trackingservice.application.location.command.update.UpdateLocationResponse;
import com.example.trackingservice.application.location.query.getList.GetListLocationDto;
import com.example.trackingservice.application.location.query.getList.GetListLocationQuery;
import com.example.trackingservice.core.web.BaseController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/location")
public class LocationController extends BaseController {

    public LocationController(Pipeline pipeline) {
        super(pipeline);
    }

    @PostMapping
    public CreateLocationResponse create(@RequestBody CreateLocationCommand createLocationCommand){
        return createLocationCommand.execute(pipeline);
    }

    @GetMapping
    public List<GetListLocationDto> get(){
        GetListLocationQuery query= new GetListLocationQuery();
        return query.execute(pipeline);
    }

    @PutMapping
    public UpdateLocationResponse update(@RequestBody UpdateLocationCommand updateLocationCommand){
        return updateLocationCommand.execute(pipeline);
    }

    @DeleteMapping
    public DeleteLocationResponse delete(@RequestBody DeleteLocationCommand deleteLocationCommand){
        return deleteLocationCommand.execute(pipeline);
    }

}
