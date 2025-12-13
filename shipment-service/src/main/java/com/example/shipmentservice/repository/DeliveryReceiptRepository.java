package com.example.shipmentservice.repository;

import com.example.shipmentservice.data.entity.DeliveryReceipt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeliveryReceiptRepository extends JpaRepository<DeliveryReceipt, UUID> {
}
