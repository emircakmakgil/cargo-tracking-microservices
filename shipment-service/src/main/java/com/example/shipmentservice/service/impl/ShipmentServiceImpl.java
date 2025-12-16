package com.example.shipmentservice.service.impl;

import com.example.shipmentservice.core.exception.type.BusinessException;
import com.example.shipmentservice.data.dto.ShipmentDto.CreateShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.DeleteShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.ShipmentListiningDto;
import com.example.shipmentservice.data.dto.ShipmentDto.UpdateShipmentDto;
import com.example.shipmentservice.data.entity.*;
import com.example.shipmentservice.data.entity.Package;
import com.example.shipmentservice.mapper.ShipmentMapper;
import com.example.shipmentservice.repository.ShipmentRepository;
import com.example.shipmentservice.service.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.example.shipmentservice.constant.GeneralConstant.*;

@Service
public class ShipmentServiceImpl implements ShipmentService {
    private final ShipmentRepository shipmentRepository;
    private final ShipmentMapper shipmentMapper;
    private final ContactService contactService;
    private final ServiceTypeService serviceTypeService;
    private final LocationService locationService;
    private final DeliveryReceiptService deliveryReceiptService;
    private final PackageService packageService;

    public ShipmentServiceImpl(ShipmentRepository shipmentRepository, ShipmentMapper shipmentMapper, ContactService contactService, ServiceTypeService serviceTypeService, LocationService locationService, DeliveryReceiptService deliveryReceiptService, PackageService packageService) {
        this.shipmentRepository = shipmentRepository;
        this.shipmentMapper = shipmentMapper;
        this.contactService = contactService;
        this.serviceTypeService = serviceTypeService;
        this.locationService = locationService;
        this.deliveryReceiptService = deliveryReceiptService;
        this.packageService = packageService;
    }

    @Override
    public List<Shipments> findAll(List<UUID> shipmentId) {
        return shipmentRepository.findAllById(shipmentId);
    }

    @Override
    public Shipments findById(UUID id) {
        return shipmentRepository.findById(id).orElseThrow(()-> new BusinessException(SHIPMENT_TYPE_NOT_FOUND +" : "+id));
    }

    @Override
    public void add(CreateShipmentDto createShipmentDto) {
        Contact receiver = contactService.findById(createShipmentDto.getReceiverContactId());
        Contact sender   = contactService.findById(createShipmentDto.getSenderContactId());
        Location location=locationService.findById(createShipmentDto.getLocationId());
        ServiceType serviceType=serviceTypeService.findById(createShipmentDto.getServiceTypeId());
        DeliveryReceipt deliveryReceipt=deliveryReceiptService.findById(createShipmentDto.getDeliveryReceiptId());
        Package packages=packageService.findById(createShipmentDto.getPackageId());
        if (receiver == null) {
            throw new BusinessException(RECEIVER_NOT_FOUND);
        }

        if (sender == null) {
            throw new BusinessException(SENDER_NOT_FOUND);
        }
        if (sender.getId().equals(receiver.getId())) {
            throw new BusinessException(SENDER_AND_RECEIVER_CANNOT_BE_SAME);
        }


        Shipments shipments = shipmentMapper
                .createShipmentFromCreateReceiverShipmentDto(createShipmentDto);
        shipments.setReceiverContact(receiver);
        shipments.setSenderContact(sender);
        shipments.setLocation(location);
        shipments.setServiceType(serviceType);
        shipments.setDeliveryReceipt(deliveryReceipt);
        shipments.setPackages(packages);
        shipmentRepository.saveAndFlush(shipments);
    }


    @Override
    public List<ShipmentListiningDto> getAll() {
        List<Shipments> shipments=shipmentRepository.findAll();
        return shipments.stream().map(shipmentMapper::toShipmentListiningDto).collect(Collectors.toList());
    }

    @Override
    public List<ShipmentListiningDto> getReceiverShipment(UUID id) {
        return shipmentRepository.findAll()
                .stream()
                .filter(shipments1 -> shipments1.getId() == id)
                .map(shipmentMapper::toShipmentListiningDto)
                .toList();

    }


        @Override
    public List<ShipmentListiningDto> getSenderShipment(UUID id) {
        List<Shipments> shipments =
                shipmentRepository.getSenderShipment(id);

        return shipments.stream()
                .map(shipmentMapper::toShipmentListiningDto)
                .toList();
    }


    @Override
    public Shipments update(UpdateShipmentDto updateShipmentDto) {
        Contact contact = contactService.findById(updateShipmentDto.getReceiverContactId());
        Location location=locationService.findById(updateShipmentDto.getLocationId());
        ServiceType serviceType=serviceTypeService.findById(updateShipmentDto.getServiceTypeId());
        DeliveryReceipt deliveryReceipt=deliveryReceiptService.findById(updateShipmentDto.getDeliveryReceiptId());
        Package packages=packageService.findById(updateShipmentDto.getPackageId());

        if (contact == null) {
            throw new BusinessException(RECEIVER_NOT_FOUND);
        }

        Shipments shipments=shipmentRepository.findById(updateShipmentDto.getId()).orElseThrow(()-> new BusinessException(SHIPMENT_TYPE_NOT_FOUND+ " : "+ updateShipmentDto.getId()));
        shipmentMapper.updateShipmentFromUpdateReceiverShipmentDto(updateShipmentDto,shipments);
        shipments.setReceiverContact(contact);
        shipments.setLocation(location);
        shipments.setServiceType(serviceType);
        shipments.setDeliveryReceipt(deliveryReceipt);
        shipments.setPackages(packages);
        return shipments;
    }

    @Override
    public void delete(DeleteShipmentDto deleteShipmentDto) {
        Contact contact = contactService.findById(deleteShipmentDto.getReceiverContactId());

        if(contact == null){
            throw new BusinessException(RECEIVER_NOT_FOUND);
        }

        Shipments shipments=shipmentRepository.findById(deleteShipmentDto.getId()).orElseThrow(()-> new BusinessException(SHIPMENT_TYPE_NOT_FOUND+ " : "+ deleteShipmentDto.getId()));
        shipmentRepository.delete(shipments);
    }
}
