package com.example.shipmentservice.service;

import com.example.shipmentservice.data.dto.ShipmentDto.ReceiverDto.CreateReceiverShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.ReceiverDto.DeleteReceiverShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.ReceiverDto.ReceiverShipmentListiningDto;
import com.example.shipmentservice.data.dto.ShipmentDto.ReceiverDto.UpdateReceiverShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.SenderDto.CreateSenderShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.SenderDto.DeleteSenderShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.SenderDto.SenderShipmentListiningDto;
import com.example.shipmentservice.data.dto.ShipmentDto.SenderDto.UpdateSenderShipmentDto;
import com.example.shipmentservice.data.entity.Shipments;

import java.util.List;
import java.util.UUID;

public interface ShipmentService {
    List<Shipments> findAll(List<UUID> shipmentId);
    Shipments findById(UUID id);
    void addReceiverShipment(CreateReceiverShipmentDto createReceiverShipmentDto);
    List<ReceiverShipmentListiningDto> getReceiverShipmentAll();
    Shipments updateReceiverShipment(UpdateReceiverShipmentDto updateReceiverShipmentDto);
    void deleteReceiverShipment(DeleteReceiverShipmentDto deleteReceiverShipmentDto);
    void addSenderShipment(CreateSenderShipmentDto createSenderShipmentDto);
    List<SenderShipmentListiningDto> getSenderShipmentAll();
    Shipments updateSenderShipment(UpdateSenderShipmentDto updateSenderShipmentDto);
    void deleteSenderShipment(DeleteSenderShipmentDto deleteSenderShipmentDto);




}
