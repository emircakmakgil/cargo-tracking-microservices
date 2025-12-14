package com.example.shipmentservice.repository;

import com.example.shipmentservice.data.entity.Shipments;
import com.example.shipmentservice.model.enums.ShipmentLifecycleStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShipmentRepository extends JpaRepository<Shipments, UUID> {
    Optional<Shipments> findByTrackingNumber(String trackingNumber);
    List<Shipments> findByShipmentLifecycleStatus(ShipmentLifecycleStatus shipmentLifecycleStatus);
    List<Shipments> findBySenderContactId(UUID senderContactId);
    List<Shipments> findByReceiverContactId(UUID receiverContactId);
    List<Shipments> findByLocationId(UUID locationId);
    List<Shipments> findByEstimateDeliveryDateBetween(LocalDateTime start, LocalDateTime end);
}
