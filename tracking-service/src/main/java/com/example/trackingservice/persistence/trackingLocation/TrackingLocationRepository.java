package com.example.trackingservice.persistence.trackingLocation;

import com.example.trackingservice.domain.entity.TrackingLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrackingLocationRepository extends JpaRepository<TrackingLocation, UUID> {
}
