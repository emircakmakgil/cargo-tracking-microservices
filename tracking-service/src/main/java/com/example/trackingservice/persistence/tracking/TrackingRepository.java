package com.example.trackingservice.persistence.tracking;

import com.example.trackingservice.domain.entity.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrackingRepository extends JpaRepository<Tracking, UUID> {
}
