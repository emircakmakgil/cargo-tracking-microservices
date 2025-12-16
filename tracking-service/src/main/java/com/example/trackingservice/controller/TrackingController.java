package com.example.trackingservice.controller;

import an.awesome.pipelinr.Pipeline;
import com.example.trackingservice.application.tracking.command.create.CreateTrackingCommand;
import com.example.trackingservice.application.tracking.command.create.CreateTrackingResponse;
import com.example.trackingservice.application.tracking.command.delete.DeleteTrackingCommand;
import com.example.trackingservice.application.tracking.command.delete.DeleteTrackingResponse;
import com.example.trackingservice.application.tracking.command.update.UpdateTrackingCommand;
import com.example.trackingservice.application.tracking.command.update.UpdateTrackingResponse;
import com.example.trackingservice.application.tracking.query.getList.GetListTrackingDto;
import com.example.trackingservice.application.tracking.query.getList.GetListTrackingQuery;
import com.example.trackingservice.core.web.BaseController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tracking")
public class TrackingController extends BaseController {

    public TrackingController(Pipeline pipeline) {
        super(pipeline);
    }

    @PostMapping
    public CreateTrackingResponse create(@RequestBody CreateTrackingCommand command){
        return command.execute(pipeline);
    }

   @PutMapping
    public UpdateTrackingResponse update(@RequestBody UpdateTrackingCommand command){
        return command.execute(pipeline);
   }
   @DeleteMapping
    public DeleteTrackingResponse delete(@RequestBody DeleteTrackingCommand command){
        return command.execute(pipeline);
   }
   @GetMapping
   public List<GetListTrackingDto> get(){
       GetListTrackingQuery query= new GetListTrackingQuery();
       return query.execute(pipeline);
   }
}
