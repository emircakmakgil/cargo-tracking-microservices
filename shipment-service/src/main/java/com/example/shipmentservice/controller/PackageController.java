package com.example.shipmentservice.controller;


import com.example.shipmentservice.data.dto.PackageDto.CreatePackageDto;
import com.example.shipmentservice.data.dto.PackageDto.DeletePackageDto;
import com.example.shipmentservice.data.dto.PackageDto.PackageListiningDto;
import com.example.shipmentservice.data.dto.PackageDto.UpdatePackageDto;
import com.example.shipmentservice.service.PackageService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/package")
public class PackageController {
    private final PackageService packageService;

    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Get package information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = PackageListiningDto.class)
                    )
            )
    })
    @GetMapping
    public List<PackageListiningDto> getAll() {
        return packageService.getAll();
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Add package information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CreatePackageDto.class)
                    )
            )
    })
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreatePackageDto createPackageDto){
        packageService.add(createPackageDto);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Update package information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UpdatePackageDto.class)
                    )
            )
    })
    @PutMapping
    public void update(@RequestBody UpdatePackageDto updatePackageDto) {
        packageService.update(updatePackageDto);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Delete package information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = DeletePackageDto.class)
                    )
            )
    })
    @DeleteMapping
    public void delete(@RequestBody DeletePackageDto deletePackageDto) {
        packageService.delete(deletePackageDto);
    }

}
