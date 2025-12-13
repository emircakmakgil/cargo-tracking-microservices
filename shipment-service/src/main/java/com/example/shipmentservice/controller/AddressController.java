package com.example.shipmentservice.controller;

import com.example.shipmentservice.data.dto.AddressDto.AddressListiningDto;
import com.example.shipmentservice.data.dto.AddressDto.CreateAddressDto;
import com.example.shipmentservice.data.dto.AddressDto.DeleteAddressDto;
import com.example.shipmentservice.data.dto.AddressDto.UpdateAddressDto;
import com.example.shipmentservice.service.AddressService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Get Address information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AddressListiningDto.class)
                    )
            )
    })
    @GetMapping
    public List<AddressListiningDto> getAll() {
        return addressService.getAll();
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Add address information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AddressListiningDto.class)
                    )
            )
    })
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateAddressDto createAddressDto){
        addressService.add(createAddressDto);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Update address information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AddressListiningDto.class)
                    )
            )
    })
    @PutMapping
    public void update(@RequestBody UpdateAddressDto updateAddressDto) {
        addressService.update(updateAddressDto);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Delete address information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AddressListiningDto.class)
                    )
            )
    })
    @DeleteMapping
    public void delete(@RequestBody DeleteAddressDto deleteAddressDto) {
        addressService.delete(deleteAddressDto);
    }
}
