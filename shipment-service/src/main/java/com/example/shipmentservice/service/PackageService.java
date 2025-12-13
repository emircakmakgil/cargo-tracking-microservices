package com.example.shipmentservice.service;


import com.example.shipmentservice.data.dto.PackageDto.CreatePackageDto;
import com.example.shipmentservice.data.dto.PackageDto.DeletePackageDto;
import com.example.shipmentservice.data.dto.PackageDto.PackageListiningDto;
import com.example.shipmentservice.data.dto.PackageDto.UpdatePackageDto;
import com.example.shipmentservice.data.entity.Package;

import java.util.List;
import java.util.UUID;

public interface PackageService {
    List<Package> findAll(List<UUID> packageId);
    Package findById(UUID id);
    void add(CreatePackageDto createPackageDto);
    List<PackageListiningDto> getAll();
    Package update(UpdatePackageDto updatePackageDto);
    void delete(DeletePackageDto deletePackageDto);

}
