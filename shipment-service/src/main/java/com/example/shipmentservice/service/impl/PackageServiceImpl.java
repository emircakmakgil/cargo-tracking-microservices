package com.example.shipmentservice.service.impl;


import com.example.shipmentservice.data.dto.PackageDto.CreatePackageDto;
import com.example.shipmentservice.data.dto.PackageDto.DeletePackageDto;
import com.example.shipmentservice.data.dto.PackageDto.PackageListiningDto;
import com.example.shipmentservice.data.dto.PackageDto.UpdatePackageDto;
import com.example.shipmentservice.data.entity.Package;
import com.example.shipmentservice.mapper.PackageMapper;
import com.example.shipmentservice.repository.PackageRepository;
import com.example.shipmentservice.service.PackageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.example.shipmentservice.constant.GeneralConstant.PACKAGE_NOT_FOUND;

@Service
public class PackageServiceImpl implements PackageService {
    private final PackageRepository packageRepository;
    private final PackageMapper packageMapper;

    public PackageServiceImpl(PackageRepository packageRepository, PackageMapper packageMapper) {
        this.packageRepository = packageRepository;
        this.packageMapper = packageMapper;
    }

    @Override
    public List<Package> findAll(List<UUID> packageId) {
        return packageRepository.findAllById(packageId);
    }

    @Override
    public Package findById(UUID id) {
        return packageRepository.findById(id).orElseThrow(()-> new RuntimeException(PACKAGE_NOT_FOUND +" : "+id));
    }

    @Override
    public void add(CreatePackageDto createPackageDto) {
        Package packages= packageMapper.createPackageFromCreatePackageDto(createPackageDto);
        packageRepository.saveAndFlush(packages);

    }

    @Override
    public List<PackageListiningDto> getAll() {
        List<Package> packages=packageRepository.findAll();
        return packages.stream().map(packageMapper::toPackageListiningDto).collect(Collectors.toList());
    }

    @Override
    public Package update(UpdatePackageDto updatePackageDto) {
        Package packages=packageRepository.findById(updatePackageDto.getId()).orElseThrow(()->new RuntimeException(PACKAGE_NOT_FOUND +" : "+updatePackageDto.getId()));
        packageMapper.updatePackageFromUpdatePackageDto(updatePackageDto,packages);
        return packages;
    }

    @Override
    public void delete(DeletePackageDto deletePackageDto) {
        Package packages=packageRepository.findById(deletePackageDto.getId()).orElseThrow(()-> new RuntimeException(PACKAGE_NOT_FOUND +" : "+deletePackageDto.getId()));
        packageRepository.saveAndFlush(packages);
    }


}
