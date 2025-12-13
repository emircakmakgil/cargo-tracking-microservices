package com.example.shipmentservice.service.impl;

import com.example.shipmentservice.data.dto.ShipmentDto.ReceiverDto.CreateReceiverShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.ReceiverDto.DeleteReceiverShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.ReceiverDto.ReceiverShipmentListiningDto;
import com.example.shipmentservice.data.dto.ShipmentDto.ReceiverDto.UpdateReceiverShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.SenderDto.CreateSenderShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.SenderDto.DeleteSenderShipmentDto;
import com.example.shipmentservice.data.dto.ShipmentDto.SenderDto.SenderShipmentListiningDto;
import com.example.shipmentservice.data.dto.ShipmentDto.SenderDto.UpdateSenderShipmentDto;
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
        return shipmentRepository.findById(id).orElseThrow(()-> new RuntimeException(SHIPMENT_TYPE_NOT_FOUND +" : "+id));
    }

    @Override
    public void addReceiverShipment(CreateReceiverShipmentDto createReceiverShipmentDto) {
        Contact contact = contactService.findById(createReceiverShipmentDto.getReceiverContactId());
        Location location=locationService.findById(createReceiverShipmentDto.getLocationId());
        ServiceType serviceType=serviceTypeService.findById(createReceiverShipmentDto.getServiceTypeId());
        DeliveryReceipt deliveryReceipt=deliveryReceiptService.findById(createReceiverShipmentDto.getDeliveryReceiptId());
        Package packages=packageService.findById(createReceiverShipmentDto.getPackageId());
        if (contact == null) {
            throw new RuntimeException(RECEIVER_NOT_FOUND);
        }

        Shipments shipments = shipmentMapper
                .createReceiverShipmentFromCreateReceiverShipmentDto(createReceiverShipmentDto);
        shipments.setReceiverContact(contact);
        shipments.setLocation(location);
        shipments.setServiceType(serviceType);
        shipments.setDeliveryReceipt(deliveryReceipt);
        shipments.setPackages(packages);
        shipmentRepository.saveAndFlush(shipments);
    }


    @Override
    public List<ReceiverShipmentListiningDto> getReceiverShipmentDto() {
        List<Shipments> shipments=shipmentRepository.findAll();
        return shipments.stream().map(shipmentMapper::toReceiverShipmentListiningDto).filter(dto -> dto.getReceiverContactId()!=null).collect(Collectors.toList());
    }

    @Override
    public Shipments updateReceiverShipment(UpdateReceiverShipmentDto updateReceiverShipmentDto) {
        Contact contact = contactService.findById(updateReceiverShipmentDto.getReceiverContactId());
        Location location=locationService.findById(updateReceiverShipmentDto.getLocationId());
        ServiceType serviceType=serviceTypeService.findById(updateReceiverShipmentDto.getServiceTypeId());
        DeliveryReceipt deliveryReceipt=deliveryReceiptService.findById(updateReceiverShipmentDto.getDeliveryReceiptId());
        Package packages=packageService.findById(updateReceiverShipmentDto.getPackageId());

        if (contact == null) {
            throw new RuntimeException(RECEIVER_NOT_FOUND);
        }

        Shipments shipments=shipmentRepository.findById(updateReceiverShipmentDto.getId()).orElseThrow(()-> new RuntimeException(SHIPMENT_TYPE_NOT_FOUND+ " : "+updateReceiverShipmentDto.getId()));
        shipmentMapper.updateReceiverShipmentFromUpdateReceiverShipmentDto(updateReceiverShipmentDto,shipments);
        shipments.setReceiverContact(contact);
        shipments.setLocation(location);
        shipments.setServiceType(serviceType);
        shipments.setDeliveryReceipt(deliveryReceipt);
        shipments.setPackages(packages);
        return shipments;
    }

    @Override
    public void deleteReceiverShipment(DeleteReceiverShipmentDto deleteReceiverShipmentDto) {
        Contact contact = contactService.findById(deleteReceiverShipmentDto.getReceiverContactId());

        if(contact == null){
            throw new RuntimeException(RECEIVER_NOT_FOUND);
        }

        Shipments shipments=shipmentRepository.findById(deleteReceiverShipmentDto.getId()).orElseThrow(()-> new RuntimeException(SHIPMENT_TYPE_NOT_FOUND+ " : "+deleteReceiverShipmentDto.getId()));
        shipmentRepository.delete(shipments);
    }



    @Override
    public void addSenderShipment(CreateSenderShipmentDto createSenderShipmentDto) {
        Contact contact=contactService.findById(createSenderShipmentDto.getSenderContactId());
        Package packages=packageService.findById(createSenderShipmentDto.getPackageId());
        Location location=locationService.findById(createSenderShipmentDto.getLocationId());
        DeliveryReceipt deliveryReceipt=deliveryReceiptService.findById(createSenderShipmentDto.getDeliveryReceiptId());
        if(contact == null){
            throw new RuntimeException(SENDER_NOT_FOUND);
        }
        Shipments shipment=shipmentMapper.createSenderShipmentFromCreateReceiverShipmentDto(createSenderShipmentDto);
        shipment.setSenderContact(contact);
        shipment.setPackages(packages);
        shipment.setLocation(location);
        shipment.setDeliveryReceipt(deliveryReceipt);
        shipmentRepository.saveAndFlush(shipment);
    }

    @Override
    public List<SenderShipmentListiningDto> getSenderShipmentDto() {
        List<Shipments> shipments=shipmentRepository.findAll();
        return shipments.stream().map(shipmentMapper::toSenderShipmentListiningDto).filter(dto->dto.getSenderContactId() !=null).collect(Collectors.toList());
    }

    @Override
    public Shipments updateSenderShipment(UpdateSenderShipmentDto updateSenderShipmentDto) {
        Contact contact=contactService.findById(updateSenderShipmentDto.getSenderContactId());
        Location location=locationService.findById(updateSenderShipmentDto.getLocationId());
        DeliveryReceipt deliveryReceipt=deliveryReceiptService.findById(updateSenderShipmentDto.getDeliveryReceiptId());
        Shipments shipments=shipmentRepository.findById(updateSenderShipmentDto.getId()).orElseThrow(()-> new RuntimeException(SENDER_NOT_FOUND));
        Package packages=packageService.findById(updateSenderShipmentDto.getPackageId());
        shipmentMapper.updateSenderShipmentFromUpdateReceiverShipmentDto(updateSenderShipmentDto,shipments);
        shipments.setSenderContact(contact);
        shipments.setLocation(location);
        shipments.setDeliveryReceipt(deliveryReceipt);
        shipments.setPackages(packages);
        return shipments;
    }

    @Override
    public void deleteSenderShipment(DeleteSenderShipmentDto deleteSenderShipmentDto) {
        Contact contact=contactService.findById(deleteSenderShipmentDto.getSenderContactId());
        if(contact ==null){
            throw new RuntimeException(SENDER_NOT_FOUND);
        }
        Shipments shipment=shipmentRepository.findById(deleteSenderShipmentDto.getId()).orElseThrow(()-> new RuntimeException(SHIPMENT_TYPE_NOT_FOUND));
        shipmentRepository.delete(shipment);
    }
}
