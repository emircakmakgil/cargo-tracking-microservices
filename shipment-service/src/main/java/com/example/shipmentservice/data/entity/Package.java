package com.example.shipmentservice.data.entity;

import com.example.shipmentservice.model.AbstractEntity;
import com.example.shipmentservice.model.enums.PackageFeature;
import com.example.shipmentservice.model.enums.PackageType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="PACKAGE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SQLRestriction("DELETED = '0'")
public class Package extends AbstractEntity {
    @NotNull(message = "Weight is required")
    @Min(value = 0, message = "Weight must be positive")
    @Max(value = 1000, message = "Weight must be less than 1000 kg")
    @Column(name="WEIGHT", nullable = false)
    private Double weight;

    @NotNull(message = "Length is required")
    @Min(value = 0, message = "Length must be positive")
    @Column(name="LENGTH", nullable = false)
    private Double length;

    @NotNull(message = "Width is required")
    @Min(value = 0, message = "Width must be positive")
    @Column(name="WIDTH", nullable = false)
    private Double width;

    @NotNull(message = "Height is required")
    @Min(value = 0, message = "Height must be positive")
    @Column(name="HEIGHT", nullable = false)
    private Double height;

    @NotNull(message = "Package type is required")
    @Enumerated(EnumType.STRING)
    @Column(name="PACKAGE_TYPE", nullable = false, length = 20)
    private PackageType packageType;

    @Enumerated(EnumType.STRING)
    @Column(name="PACKAGE_FEATURE", length = 20)
    private Set<PackageFeature> packageFeature;

    @Column(name="CONTENT_DESCRIPTION", length = 500)
    private String contentDescription;

    @OneToOne(mappedBy = "packages")
    private Shipments shipments;


}
