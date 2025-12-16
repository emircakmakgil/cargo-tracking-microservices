package com.example.trackingservice.persistence.trackingHistory;

import com.example.trackingservice.domain.entity.TrackingHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrackingHistoryRepository extends JpaRepository<TrackingHistory , UUID> {
}
