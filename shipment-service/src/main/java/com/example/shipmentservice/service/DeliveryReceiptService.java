package com.example.shipmentservice.service;

import com.example.shipmentservice.data.dto.DeliveryReceipt.CreateDeliveryReceiptDto;
import com.example.shipmentservice.data.dto.DeliveryReceipt.DeleteDeliveryReceiptDto;
import com.example.shipmentservice.data.dto.DeliveryReceipt.DeliveryReceiptListiningDto;
import com.example.shipmentservice.data.dto.DeliveryReceipt.UpdateDeliveryReceiptDto;
import com.example.shipmentservice.data.entity.DeliveryReceipt;

import java.util.List;
import java.util.UUID;

public interface DeliveryReceiptService {
    List<DeliveryReceipt> findAll(List<UUID> deliveryReceiptId);
    DeliveryReceipt findById(UUID id);
    void add(CreateDeliveryReceiptDto createDeliveryReceiptDto);
    DeliveryReceipt update(UpdateDeliveryReceiptDto updateDeliveryReceiptDto);
    void delete(DeleteDeliveryReceiptDto deleteDeliveryReceiptDto);
    List<DeliveryReceiptListiningDto> getAll();
}
