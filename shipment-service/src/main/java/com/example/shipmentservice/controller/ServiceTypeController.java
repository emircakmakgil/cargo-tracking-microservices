package com.example.shipmentservice.controller;

import com.example.shipmentservice.data.dto.ServiceTypeDto.CreateServiceTypeDto;
import com.example.shipmentservice.data.dto.ServiceTypeDto.DeleteServiceTypeDto;
import com.example.shipmentservice.data.dto.ServiceTypeDto.ServiceTypeListiningDto;
import com.example.shipmentservice.data.dto.ServiceTypeDto.UpdateServiceTypeDto;
import com.example.shipmentservice.service.ServiceTypeService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/service-type")
public class ServiceTypeController {
    private final ServiceTypeService serviceTypeService;

    public ServiceTypeController(ServiceTypeService serviceTypeService) {
        this.serviceTypeService = serviceTypeService;
    }
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Get service type information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ServiceTypeListiningDto.class)
                    )
            )
    })
    @GetMapping
    public List<ServiceTypeListiningDto> getAll() {
        return serviceTypeService.getAll();
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Add service type information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CreateServiceTypeDto.class)
                    )
            )
    })
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateServiceTypeDto createServiceTypeDto){
        serviceTypeService.add(createServiceTypeDto);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Update service type information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UpdateServiceTypeDto.class)
                    )
            )
    })
    @PutMapping
    public void update(@RequestBody UpdateServiceTypeDto updateServiceTypeDto) {
        serviceTypeService.update(updateServiceTypeDto);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Delete service type information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = DeleteServiceTypeDto.class)
                    )
            )
    })
    @DeleteMapping
    public void delete(@RequestBody DeleteServiceTypeDto deleteServiceTypeDto) {
        serviceTypeService.delete(deleteServiceTypeDto);
    }

}
