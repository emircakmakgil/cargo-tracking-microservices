package com.example.shipmentservice.rules;

import com.example.shipmentservice.core.exception.type.BusinessException;
import com.example.shipmentservice.data.entity.Contact;
import com.example.shipmentservice.data.entity.Shipments;
import com.example.shipmentservice.model.enums.ShipmentLifecycleStatus;
import org.springframework.stereotype.Component;

import static com.example.shipmentservice.constant.GeneralConstant.*;

@Component
public class ShipmentBusinessRules {

    public void checkSenderAndReceiverExists(Contact sender, Contact receiver) {

        if (sender == null) {
            throw new BusinessException(SENDER_NOT_FOUND);
        }

        if (receiver == null) {
            throw new BusinessException(RECEIVER_NOT_FOUND);
        }
    }

    public void checkSenderAndReceiverAreDifferent(Contact sender, Contact receiver) {

        if (sender.getId().equals(receiver.getId())) {
            throw new BusinessException(SENDER_AND_RECEIVER_CANNOT_BE_SAME);
        }
    }

    public void checkStatusTransition(
            ShipmentLifecycleStatus currentStatus,
            ShipmentLifecycleStatus targetStatus) {

        if (currentStatus == ShipmentLifecycleStatus.DELIVERED) {
            throw new BusinessException(SHIPMENT_ALREADY_DELIVERED);
        }

        if (currentStatus == ShipmentLifecycleStatus.CANCELLED) {
            throw new BusinessException(CANCELLED_SHIPMENT_CANNOT_CHANGE);
        }

        if (currentStatus == ShipmentLifecycleStatus.CREATED
                && targetStatus == ShipmentLifecycleStatus.DELIVERED) {
            throw new BusinessException(INVALID_STATUS_TRANSITION);
        }
    }
    public void checkShipmentUpdatable(Shipments shipment) {

        if (shipment.getShipmentLifecycleStatus() == ShipmentLifecycleStatus.DELIVERED) {
            throw new BusinessException(SHIPMENT_CANNOT_BE_UPDATED);
        }
    }


}
