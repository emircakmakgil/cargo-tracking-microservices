package com.example.shipmentservice.service;

import com.example.shipmentservice.data.dto.ShipmentDto.CreateShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.DeleteShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.ShipmentListiningDto;
import com.example.shipmentservice.data.dto.ShipmentDto.UpdateShipmentDto;
import com.example.shipmentservice.data.entity.Shipments;

import java.util.List;
import java.util.UUID;

public interface ShipmentService {
    List<Shipments> findAll(List<UUID> shipmentId);
    Shipments findById(UUID id);
    void add(CreateShipmentDto createShipmentDto);
    List<ShipmentListiningDto> getAll();
    List<ShipmentListiningDto> getReceiverShipment(UUID id);
    List<ShipmentListiningDto> getSenderShipment(UUID id);
    Shipments update(UpdateShipmentDto updateShipmentDto);
    void delete(DeleteShipmentDto deleteShipmentDto);





}
