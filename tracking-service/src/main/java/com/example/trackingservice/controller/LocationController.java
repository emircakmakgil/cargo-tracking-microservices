package com.example.trackingservice.controller;

import an.awesome.pipelinr.Pipeline;
import com.example.trackingservice.application.location.command.create.CreateLocationCommand;
import com.example.trackingservice.application.location.command.create.CreateLocationResponse;
import com.example.trackingservice.core.web.BaseController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
