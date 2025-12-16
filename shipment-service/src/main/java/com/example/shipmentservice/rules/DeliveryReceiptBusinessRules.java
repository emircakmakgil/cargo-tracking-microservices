package com.example.shipmentservice.rules;

import com.example.shipmentservice.constant.GeneralConstant;
import com.example.shipmentservice.core.exception.type.BusinessException;
import com.example.shipmentservice.data.entity.DeliveryReceipt;
import com.example.shipmentservice.model.enums.DeliveryStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.EnumSet;

import static com.example.shipmentservice.constant.GeneralConstant.DELIVERY_RECEIPT_NOT_FOUND;

@Component
public class DeliveryReceiptBusinessRules {

    private static final EnumSet<DeliveryStatus> FINAL_STATUSES =
            EnumSet.of(DeliveryStatus.SUCCESS, DeliveryStatus.FAILED);

    public void checkDeliveryReceiptExists(DeliveryReceipt deliveryReceipt) {
        if (deliveryReceipt == null) {
            throw new BusinessException(DELIVERY_RECEIPT_NOT_FOUND);
        }
    }

    public void checkRequiredFields(LocalDateTime deliveredAt, String receiverName, DeliveryStatus deliveryStatus) {
        if (deliveryStatus == null) {
            throw new BusinessException(GeneralConstant.DELIVERY_RECEIPT_STATUS_REQUIRED);
        }
        if (deliveredAt == null) {
            throw new BusinessException(GeneralConstant.DELIVERY_RECEIPT_DELIVERED_AT_REQUIRED);
        }
        if (receiverName == null || receiverName.isBlank()) {
            throw new BusinessException(GeneralConstant.DELIVERY_RECEIPT_RECEIVER_NAME_REQUIRED);
        }
    }

    public void checkNotFinalized(DeliveryStatus currentStatus) {
        if (currentStatus != null && FINAL_STATUSES.contains(currentStatus)) {
            throw new BusinessException(GeneralConstant.DELIVERY_RECEIPT_FINALIZED_CANNOT_UPDATE);
        }
    }
}
