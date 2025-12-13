package com.example.shipmentservice.data.dto.PackageDto;

import com.example.shipmentservice.model.enums.PackageFeature;
import com.example.shipmentservice.model.enums.PackageType;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CreatePackageDto {
    private Double weight;
    private Double length;
    private Double width;
    private Double height;
    private PackageType packageType;
    private Set<PackageFeature> packageFeature;
    private String contentDescription;
}
