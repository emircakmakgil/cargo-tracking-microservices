package com.example.shipmentservice.controller;

import com.example.shipmentservice.data.dto.ShipmentDto.CreateShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.DeleteShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.ShipmentListiningDto;
import com.example.shipmentservice.data.dto.ShipmentDto.UpdateShipmentDto;
import com.example.shipmentservice.service.ShipmentService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/shipment")
public class ShipmentController {
    private final ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Get receiver shipment information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ShipmentListiningDto.class)
                    )
            )
    })
    @GetMapping
    public List<ShipmentListiningDto> getAll() {
        return shipmentService.getAll();
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Add receiver shipment information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CreateShipmentDto.class)
                    )
            )
    })
    @PostMapping(("/add-receivers-shipments"))
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateShipmentDto createShipmentDto){
        shipmentService.add(createShipmentDto);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Update receiver shipment information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UpdateShipmentDto.class)
                    )
            )
    })
    @PutMapping(("/update-receivers-shipments"))
    public void update(@RequestBody UpdateShipmentDto updateShipmentDto) {
        shipmentService.update(updateShipmentDto);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Delete receiver shipment information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = DeleteShipmentDto.class)
                    )
            )
    })
    @DeleteMapping(("/delete-receivers-shipments"))
    public void delete(@RequestBody DeleteShipmentDto deleteShipmentDto) {
        shipmentService.delete(deleteShipmentDto);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Get receiver shipment information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ShipmentListiningDto.class)
                    )
            )
    })
    @GetMapping(("/get-receivers-shipments"))
    public List<ShipmentListiningDto> getReceiverShipment(@RequestParam UUID id) {
        return shipmentService.getReceiverShipment(id);
    }
}
