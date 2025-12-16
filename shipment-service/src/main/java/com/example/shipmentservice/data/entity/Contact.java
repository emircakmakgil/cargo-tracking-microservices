package com.example.shipmentservice.data.entity;

import com.example.shipmentservice.model.AbstractEntity;
import com.example.shipmentservice.model.enums.PackageType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;


import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="Contact", indexes = {
        @Index(name = "idx_email", columnList = "EMAIL"),
        @Index(name = "idx_phone", columnList = "PHONE_NUMBER"),
        @Index(name = "idx_user_id", columnList = "USER_ID")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SQLRestriction("DELETED = '0'")
public class Contact extends AbstractEntity {

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Phone number must be 10-15 digits")
    private String phoneNumber;

    @Email(message = "Email must be valid")  // @Pattern yerine @Email kullan
    private String email;

    @OneToMany(mappedBy="contract",fetch = FetchType.LAZY)
    private Set<ContractCross> contractCross;

    @OneToMany(mappedBy="senderContact",fetch = FetchType.LAZY)
    private Set<Shipments> senderShipments;

    @OneToMany(mappedBy="receiverContact",fetch = FetchType.LAZY)
    private Set<Shipments> receiverShipments;

    // İleride user service eklendiğinde kullanılacak
    @Column(name = "USER_ID", nullable = true)
    private String userId; // User service'den gelecek user ID (opsiyonel)
}
