package com.example.trackingservice.domain.entity;

import com.example.trackingservice.model.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TRACKING_LOCATION", indexes = {
        @Index(name = "idx_tl_shipment", columnList = "SHIPMENT_ID"),
        @Index(name = "idx_tl_location", columnList = "LOCATION_ID")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrackingLocation extends AbstractEntity {

    @Column(name = "SHIPMENT_ID", nullable = false)
    private UUID shipmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRACKING_ID", nullable = false)
    private Tracking tracking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOCATION_ID", nullable = false)
    private Location location;

    @Column(name = "ARRIVAL_TIME", nullable = false)
    private LocalDateTime arrivalTime;

    @Column(name = "DEPARTURE_TIME")
    private LocalDateTime departureTime;
}