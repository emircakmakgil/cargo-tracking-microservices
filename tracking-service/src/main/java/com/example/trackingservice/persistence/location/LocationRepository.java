package com.example.trackingservice.persistence.location;

import com.example.trackingservice.domain.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocationRepository extends JpaRepository<Location, UUID> {
}
