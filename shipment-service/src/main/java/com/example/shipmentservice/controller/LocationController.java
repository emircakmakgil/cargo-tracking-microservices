package com.example.shipmentservice.controller;

import com.example.shipmentservice.data.dto.LocationDto.CreateLocationDto;
import com.example.shipmentservice.data.dto.LocationDto.DeleteLocationDto;
import com.example.shipmentservice.data.dto.LocationDto.LocationListiningDto;
import com.example.shipmentservice.data.dto.LocationDto.UpdateLocationDto;
import com.example.shipmentservice.service.LocationService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/location")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Get Location information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = LocationListiningDto.class)
                    )
            )
    })
    @GetMapping
    public List<LocationListiningDto> getAll() {
        return locationService.getAll();
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Add location information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CreateLocationDto.class)
                    )
            )
    })
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateLocationDto createLocationDto){
        locationService.add(createLocationDto);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Update location information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UpdateLocationDto.class)
                    )
            )
    })
    @PutMapping
    public void update(@RequestBody UpdateLocationDto updateLocationDto) {
        locationService.update(updateLocationDto);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Delete location information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = DeleteLocationDto.class)
                    )
            )
    })
    @DeleteMapping
    public void delete(@RequestBody DeleteLocationDto deleteLocationDto) {
        locationService.delete(deleteLocationDto);
    }
}
