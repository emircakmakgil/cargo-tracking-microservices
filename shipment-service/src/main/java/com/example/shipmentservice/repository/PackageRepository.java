package com.example.shipmentservice.repository;

import com.example.shipmentservice.data.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PackageRepository extends JpaRepository<Package, UUID> {
}
