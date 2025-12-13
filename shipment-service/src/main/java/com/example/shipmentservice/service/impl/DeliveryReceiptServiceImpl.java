package com.example.shipmentservice.service.impl;

import com.example.shipmentservice.data.dto.DeliveryReceipt.CreateDeliveryReceiptDto;
import com.example.shipmentservice.data.dto.DeliveryReceipt.DeleteDeliveryReceiptDto;
import com.example.shipmentservice.data.dto.DeliveryReceipt.DeliveryReceiptListiningDto;
import com.example.shipmentservice.data.dto.DeliveryReceipt.UpdateDeliveryReceiptDto;
import com.example.shipmentservice.data.entity.DeliveryReceipt;
import com.example.shipmentservice.mapper.DeliveryReceiptMapper;
import com.example.shipmentservice.repository.DeliveryReceiptRepository;
import com.example.shipmentservice.service.DeliveryReceiptService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.example.shipmentservice.constant.GeneralConstant.DELIVERY_RECEIPT_NOT_FOUND;

@Service
public class DeliveryReceiptServiceImpl implements DeliveryReceiptService {
    private final DeliveryReceiptRepository deliveryReceiptRepository;
    private final DeliveryReceiptMapper deliveryReceiptMapper;

    public DeliveryReceiptServiceImpl(DeliveryReceiptRepository deliveryReceiptRepository, DeliveryReceiptMapper deliveryReceiptMapper) {
        this.deliveryReceiptRepository = deliveryReceiptRepository;
        this.deliveryReceiptMapper = deliveryReceiptMapper;
    }

    @Override
    public List<DeliveryReceipt> findAll(List<UUID> deliveryReceiptId) {
        return deliveryReceiptRepository.findAllById(deliveryReceiptId);
    }

    @Override
    public DeliveryReceipt findById(UUID id) {
        return deliveryReceiptRepository.findById(id).orElseThrow(()-> new RuntimeException(DELIVERY_RECEIPT_NOT_FOUND));

    }

    @Override
    public void add(CreateDeliveryReceiptDto createDeliveryReceiptDto) {
        DeliveryReceipt deliveryReceipt= deliveryReceiptMapper.createDeliveryReceiptFromCreateDeliveryReceipt(createDeliveryReceiptDto);
        deliveryReceiptRepository.saveAndFlush(deliveryReceipt);

    }

    @Override
    public DeliveryReceipt update(UpdateDeliveryReceiptDto updateDeliveryReceiptDto) {
        DeliveryReceipt deliveryReceipt=deliveryReceiptRepository.findById(updateDeliveryReceiptDto.getId()).orElseThrow(()-> new RuntimeException(DELIVERY_RECEIPT_NOT_FOUND));
        deliveryReceiptMapper.updateDeliveryReceiptFromUpdateDeliveryReceiptDto(updateDeliveryReceiptDto,deliveryReceipt);
        return deliveryReceipt;
    }

    @Override
    public void delete(DeleteDeliveryReceiptDto deleteDeliveryReceiptDto) {
        DeliveryReceipt deliveryReceipt=deliveryReceiptRepository.findById(deleteDeliveryReceiptDto.getId()).orElseThrow(()-> new RuntimeException(DELIVERY_RECEIPT_NOT_FOUND));
        deliveryReceiptRepository.saveAndFlush(deliveryReceipt);
    }

    @Override
    public List<DeliveryReceiptListiningDto> getAll() {
        List<DeliveryReceipt> deliveryReceipts= deliveryReceiptRepository.findAll();
        return deliveryReceipts.stream().map(deliveryReceiptMapper::toDeliveryReceiptDto).collect(Collectors.toList());
    }
}
