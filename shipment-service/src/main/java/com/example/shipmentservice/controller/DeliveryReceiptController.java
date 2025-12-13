package com.example.shipmentservice.controller;

import com.example.shipmentservice.data.dto.DeliveryReceipt.CreateDeliveryReceiptDto;
import com.example.shipmentservice.data.dto.DeliveryReceipt.DeleteDeliveryReceiptDto;
import com.example.shipmentservice.data.dto.DeliveryReceipt.DeliveryReceiptListiningDto;
import com.example.shipmentservice.data.dto.DeliveryReceipt.UpdateDeliveryReceiptDto;
import com.example.shipmentservice.service.DeliveryReceiptService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/delivery-receipt")
public class DeliveryReceiptController {
    private final DeliveryReceiptService deliveryReceiptService;

    public DeliveryReceiptController(DeliveryReceiptService deliveryReceiptService) {
        this.deliveryReceiptService = deliveryReceiptService;
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Get Delivery Receipt information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = DeliveryReceiptListiningDto.class)
                    )
            )
    })
    @GetMapping
    public List<DeliveryReceiptListiningDto> getAll() {
        return deliveryReceiptService.getAll();
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Add contact information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CreateDeliveryReceiptDto.class)
                    )
            )
    })
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateDeliveryReceiptDto deliveryReceiptDto){
        deliveryReceiptService.add(deliveryReceiptDto);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Update delivery receipt information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UpdateDeliveryReceiptDto.class)
                    )
            )
    })
    @PutMapping
    public void update(@RequestBody UpdateDeliveryReceiptDto updateDeliveryReceiptDto) {
        deliveryReceiptService.update(updateDeliveryReceiptDto);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Delete delivery receipt information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = DeleteDeliveryReceiptDto.class)
                    )
            )
    })
    @DeleteMapping
    public void delete(@RequestBody DeleteDeliveryReceiptDto deleteDeliveryReceiptDto) {
        deliveryReceiptService.delete(deleteDeliveryReceiptDto);
    }
}
