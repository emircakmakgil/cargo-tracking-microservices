package com.example.trackingservice.domain.entity;


import com.example.trackingservice.model.AbstractEntity;
import com.example.trackingservice.model.enums.TrackingStatusCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "TRACKING",
        indexes = {
                @Index(name = "idx_tracking_shipment", columnList = "SHIPMENT_ID"),
                @Index(name = "idx_tracking_status", columnList = "STATUS"),
                @Index(name = "idx_tracking_event_time", columnList = "EVENT_TIME")
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tracking extends AbstractEntity {

    @Column(name = "SHIPMENT_ID", updatable = false)
    private UUID shipmentId;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false, length = 30)
    private TrackingStatusCode status;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "EVENT_TIME", nullable = false)
    private LocalDateTime eventTime;
}
