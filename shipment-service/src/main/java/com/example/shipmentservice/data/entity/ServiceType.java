package com.example.shipmentservice.data.entity;

import com.example.shipmentservice.model.AbstractEntity;
import com.example.shipmentservice.model.enums.DeliverySlaType;
import com.example.shipmentservice.model.enums.ServiceTypeName;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;
import java.util.Set;

@Entity
@Table(name="SERVICE_TYPE", indexes = {
        @Index(name = "idx_service_type_name", columnList = "SERVICE_TYPE_NAME"),
        @Index(name = "idx_active", columnList = "ACTIVE")
})@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SQLRestriction("DELETED = '0'")
public class ServiceType extends AbstractEntity {
    @NotNull(message = "Service type name is required")
    @Enumerated(EnumType.STRING)
    @Column(name="SERVICE_TYPE_NAME", nullable = false, length = 50)
    private ServiceTypeName serviceTypeName;

    @NotNull(message = "Base price is required")
    @Min(value = 0, message = "Base price must be positive")
    @Column(name="BASE_PRICE", nullable = false)
    private Double basePrice;


    @Enumerated(EnumType.STRING)
    @Column(name="DELIVERY_SLA_TYPE")
    private DeliverySlaType deliverySlaType;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "MIN_WEIGHT")
    private Double minWeight;

    @Column(name = "MAX_WEIGHT")
    private Double maxWeight;

    @Column(name = "MAX_LENGTH")
    private Double maxLength;

    @Column(name = "MAX_WIDTH")
    private Double maxWidth;

    @Column(name = "MAX_HEIGHT")
    private Double maxHeight;

    @Column(name = "ACTIVE", nullable = false)
    @Builder.Default
    private Boolean active = true;

    @Column(name = "ADDITIONAL_FEE")
    private Double additionalFee;

    @OneToMany(mappedBy = "serviceType",fetch = FetchType.LAZY)
    private Set<Shipments> shipments;
}







