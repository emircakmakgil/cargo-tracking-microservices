package com.example.shipmentservice.data.entity;

import com.example.shipmentservice.model.AbstractEntity;
import com.example.shipmentservice.model.enums.LocationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="LOCATION", indexes = {
        @Index(name = "idx_type", columnList = "TYPE"),
        @Index(name = "idx_center_name", columnList = "CENTER_NAME")
})
@SQLRestriction("DELETED = '0'")
public class Location extends AbstractEntity {

    @NotBlank(message = "Center name is required")
    @Size(max = 200, message = "Center name must be max 200 characters")
    @Column(name="CENTER_NAME", nullable = false, length = 200)
    private String centerName;

    @NotNull(message = "Location type is required")
    @Enumerated(EnumType.STRING)
    @Column(name="TYPE", nullable = false, length = 20)
    private LocationType type;

    @OneToMany(mappedBy = "location",fetch = FetchType.LAZY)
    private Set<Shipments> shipments;

}
