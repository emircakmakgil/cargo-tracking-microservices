package com.example.shipmentservice.data.entity;

import com.example.shipmentservice.model.AbstractEntity;
import com.example.shipmentservice.model.enums.DeliveryStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;
import java.util.UUID;

//TODO: TESLİM EDEN KİŞİ BİLGİLERİ DE EKLENMELİ
@Entity
@Table(name="DELIVERY_RECEIPT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SQLRestriction("DELETED = '0'")
public class DeliveryReceipt extends AbstractEntity {

    @NotNull(message = "Delivery status is required")
    @Enumerated(EnumType.STRING)
    @Column(name="DELIVERY_STATUS", nullable = false, length = 20)
    private DeliveryStatus deliveryStatus;

    @Column(name="DELIVERED_AT", nullable = false)
    private LocalDateTime deliveredAt;

    @Column(name="RECEIVER_NAME", nullable = false, length = 200)
    private String receiverName;

    @URL(message = "Signature image must be a valid URL")
    @Column(name = "SIGNATURE_IMAGE_URL")
    private String signatureImageUrl;

    @Column(name="DELIVERY_NOTES")
    private String deliveryNotes;

    @OneToOne(mappedBy = "deliveryReceipt")
    private Shipments shipments;

}
