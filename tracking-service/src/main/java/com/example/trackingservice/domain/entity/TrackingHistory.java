package com.example.trackingservice.domain.entity;

import com.example.trackingservice.model.AbstractEntity;
import com.example.trackingservice.model.enums.TrackingStatusCode;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TRACKING_HISTORY", indexes = {
        @Index(name = "idx_th_shipment", columnList = "SHIPMENT_ID"),
        @Index(name = "idx_th_event_time", columnList = "EVENT_TIME")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrackingHistory extends AbstractEntity {

    @Column(name = "SHIPMENT_ID", nullable = false)
    private UUID shipmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRACKING_ID", nullable = false)
    private Tracking tracking;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private TrackingStatusCode status;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "EVENT_TIME", nullable = false)
    private LocalDateTime eventTime;
}