package com.example.shipmentservice.controller;

import com.example.shipmentservice.data.dto.ShipmentDto.ReceiverDto.CreateReceiverShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.ReceiverDto.DeleteReceiverShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.ReceiverDto.ReceiverShipmentListiningDto;
import com.example.shipmentservice.data.dto.ShipmentDto.ReceiverDto.UpdateReceiverShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.SenderDto.CreateSenderShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.SenderDto.DeleteSenderShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.SenderDto.SenderShipmentListiningDto;
import com.example.shipmentservice.data.dto.ShipmentDto.SenderDto.UpdateSenderShipmentDto;
import com.example.shipmentservice.service.ShipmentService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
                            schema = @Schema(implementation = ReceiverShipmentListiningDto.class)
                    )
            )
    })
    @GetMapping(("/get-receivers-shipments"))
    public List<ReceiverShipmentListiningDto> getReceiverShipmentAll() {
        return shipmentService.getReceiverShipmentAll();
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Add receiver shipment information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CreateReceiverShipmentDto.class)
                    )
            )
    })
    @PostMapping(("/add-receivers-shipments"))
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateReceiverShipmentDto createReceiverShipmentDto){
        shipmentService.addReceiverShipment(createReceiverShipmentDto);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Update receiver shipment information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UpdateReceiverShipmentDto.class)
                    )
            )
    })
    @PutMapping(("/update-receivers-shipments"))
    public void update(@RequestBody UpdateReceiverShipmentDto updateReceiverShipmentDto) {
        shipmentService.updateReceiverShipment(updateReceiverShipmentDto);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Delete receiver shipment information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = DeleteReceiverShipmentDto.class)
                    )
            )
    })
    @DeleteMapping(("/delete-receivers-shipments"))
    public void delete(@RequestBody DeleteReceiverShipmentDto deleteReceiverShipmentDto) {
        shipmentService.deleteReceiverShipment(deleteReceiverShipmentDto);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Get sender shipment information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = SenderShipmentListiningDto.class)
                    )
            )
    })
    @GetMapping(("/get-sender-shipments"))
    public List<SenderShipmentListiningDto> getSenderShipmentAll() {
        return shipmentService.getSenderShipmentAll();
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Add sender shipment information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CreateSenderShipmentDto.class)
                    )
            )
    })
    @PostMapping(("/add-sender-shipments"))
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateSenderShipmentDto createSenderShipmentDto){
        shipmentService.addSenderShipment(createSenderShipmentDto);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Update sender shipment information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UpdateSenderShipmentDto.class)
                    )
            )
    })
    @PutMapping(("/update-sender-shipments"))
    public void update(@RequestBody UpdateSenderShipmentDto updateSenderShipmentDto) {
        shipmentService.updateSenderShipment(updateSenderShipmentDto);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Delete sender shipment information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = DeleteSenderShipmentDto.class)
                    )
            )
    })
    @DeleteMapping(("/delete-sender-shipments"))
    public void delete(@RequestBody DeleteSenderShipmentDto deleteSenderShipmentDto) {
        shipmentService.deleteSenderShipment(deleteSenderShipmentDto);
    }

}
