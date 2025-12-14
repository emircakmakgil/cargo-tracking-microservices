package com.example.shipmentservice.data.entity;

import com.example.shipmentservice.model.AbstractEntity;

import com.example.shipmentservice.model.enums.ShipmentLifecycleStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;
import java.time.LocalDateTime;

@Entity
@Table(name="SHIPMENT", indexes = {
        @Index(name = "idx_tracking_number", columnList = "TRACKING_NUMBER", unique = true),
        @Index(name = "idx_status_code", columnList = "STATUS_CODE"),
        @Index(name = "idx_sender_contact", columnList = "SENDER_CONTACT_ID"),
        @Index(name = "idx_receiver_contact", columnList = "RECEIVER_CONTACT_ID"),
        @Index(name = "idx_location", columnList = "LOCATION_ID"),
        @Index(name = "idx_estimate_delivery", columnList = "ESTIMATE_DELIVERY_DATE")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SQLRestriction("DELETED = '0'")
public class Shipments extends AbstractEntity {
    @NotBlank(message = "Tracking number is required")
    @Size(max = 50, message = "Tracking number must be max 50 characters")
    private String trackingNumber;

    @NotNull(message = "Status code is required")
    private ShipmentLifecycleStatus shipmentLifecycleStatus;

    @NotNull(message = "Service type is required")
    @ManyToOne
    @JoinColumn(name="service_type_id", nullable = false)
    private ServiceType serviceType;

    @NotNull(message = "Location is required")
    @ManyToOne
    @JoinColumn(name="location_id", nullable = false)
    private Location location;



    @Column(name="ESTIMATE_DELIVERY_DATE")
    private LocalDateTime estimateDeliveryDate;

    @Column(name = "IS_PAID", nullable = false)
    @Builder.Default
    private Boolean isPaid = Boolean.FALSE;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_contact_id", nullable = false)
    private Contact senderContact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_contact_id", nullable = false)
    private Contact receiverContact;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_receipt_id")
    private DeliveryReceipt deliveryReceipt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id")
    private Package packages;


}
