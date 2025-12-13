package com.example.shipmentservice.mapper;

import com.example.shipmentservice.data.dto.PackageDto.CreatePackageDto;
import com.example.shipmentservice.data.dto.PackageDto.PackageListiningDto;
import com.example.shipmentservice.data.dto.PackageDto.UpdatePackageDto;
import com.example.shipmentservice.data.entity.Package;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PackageMapper {
    public Package createPackageFromCreatePackageDto(CreatePackageDto createPackageDto){
        return Package.builder()
                .weight(createPackageDto.getWeight())
                .length(createPackageDto.getLength())
                .width(createPackageDto.getWidth())
                .height(createPackageDto.getHeight())
                .packageType(createPackageDto.getPackageType())
                .packageFeature(createPackageDto.getPackageFeature())
                .contentDescription(createPackageDto.getContentDescription())
                .build();
    }
    public void updatePackageFromUpdatePackageDto(UpdatePackageDto updatePackageDto,Package packages){
        packages.setWeight(updatePackageDto.getWeight());
        packages.setLength(updatePackageDto.getLength());
        packages.setWidth(updatePackageDto.getWidth());
        packages.setHeight(updatePackageDto.getHeight());
        packages.setPackageFeature(updatePackageDto.getFeatures());
        packages.setContentDescription(updatePackageDto.getContentDescription());
        packages.setPackageType(updatePackageDto.getPackageType());
    }
    public PackageListiningDto toPackageListiningDto(Package packages){
        return new PackageListiningDto(
                packages.getWeight(),
                packages.getLength(),
                packages.getWidth(),
                packages.getHeight(),
                packages.getPackageType(),
                packages.getPackageFeature(),
                packages.getContentDescription()
        );
    }
}

