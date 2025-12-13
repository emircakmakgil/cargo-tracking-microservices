package com.example.shipmentservice.data.dto.PackageDto;

import com.example.shipmentservice.model.enums.PackageFeature;
import com.example.shipmentservice.model.enums.PackageType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PackageListiningDto {
    private Double weight;
    private Double length;
    private Double width;
    private Double height;
    private PackageType packageType;
    private Set<PackageFeature> packageFeature;
    private String contentDescription;

    public PackageListiningDto(@NotNull(message = "Weight is required") @Min(value = 0, message = "Weight must be positive") @Max(value = 1000, message = "Weight must be less than 1000 kg") Double weight, @NotNull(message = "Length is required") @Min(value = 0, message = "Length must be positive") Double length, @NotNull(message = "Width is required") @Min(value = 0, message = "Width must be positive") Double width, @NotNull(message = "Height is required") @Min(value = 0, message = "Height must be positive") Double height, @NotNull(message = "Package type is required") PackageType packageType, Set<PackageFeature> packageFeature, String contentDescription) {
        this.weight=weight;
        this.length=length;
        this.width=width;
        this.height=height;
        this.packageType=packageType;
        this.packageFeature =packageFeature;
        this.contentDescription=contentDescription;
    }
}
