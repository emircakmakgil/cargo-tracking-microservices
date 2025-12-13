package com.example.shipmentservice.data.entity;


import com.example.shipmentservice.model.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name="CONTRACT_CROSS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SQLRestriction("DELETED = '0'")
public class ContractCross extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name="address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name="contract_id")
    private Contact contract;
}
