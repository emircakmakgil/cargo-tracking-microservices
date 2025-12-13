package com.example.shipmentservice.data.entity;

import com.example.shipmentservice.model.AbstractEntity;
import com.example.shipmentservice.model.enums.AddressType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.util.Set;

@Entity
@Table(name="ADDRESS", indexes = {
        @Index(name = "idx_city", columnList = "CITY"),
        @Index(name = "idx_zip_code", columnList = "ZIP_CODE"),
        @Index(name = "idx_country", columnList = "COUNTRY")
})@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@SQLRestriction("DELETED = '0'")
public class Address extends AbstractEntity {
    @NotBlank(message = "Street is required")
    private String street;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "Country is required")
    private String country;

    @NotBlank(message = "Zip code is required")
    @Pattern(regexp = "^[0-9]{5,10}$", message = "Zip code must be 5-10 digits")
    private String zipCode;

    @Column(name="ADDRESS_TYPE")
    private AddressType addressType;

    @Column(name="BUILDING_NUMBER")
    private String buildingNumber;

    @Column(name="APARTMENT_NUMBER")
    private String apartmentNumber;

    @Column(name = "DISTRICT")
    private String district;


    @OneToMany(mappedBy="address",fetch = FetchType.LAZY)
    private Set<ContractCross> contractCross;
}
