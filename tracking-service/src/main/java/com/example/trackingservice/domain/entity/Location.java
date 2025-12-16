package com.example.trackingservice.domain.entity;

import com.example.trackingservice.model.AbstractEntity;
import com.example.trackingservice.model.enums.LocationType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "LOCATION", indexes = {
        @Index(name = "idx_location_type", columnList = "TYPE"),
        @Index(name = "idx_location_city", columnList = "CITY")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location extends AbstractEntity {

    @Column(name = "CODE", nullable = false, unique = true, length = 50)
    private String code; // ANK-TR-01

    @Column(name = "NAME", nullable = false, length = 200)
    private String name; // Ankara Transfer Merkezi

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false, length = 30)
    private LocationType type;

    @Column(name = "CITY", nullable = false, length = 100)
    private String city;

    @Column(name = "COUNTRY", nullable = false, length = 100)
    private String country;
}
