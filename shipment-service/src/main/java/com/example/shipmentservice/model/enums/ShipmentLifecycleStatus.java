package com.example.shipmentservice.model.enums;

import lombok.Getter;

@Getter
public enum ShipmentLifecycleStatus {
    CREATED("1", "Gönderi oluşturuldu ve işlenmeyi bekliyor."),
    CANCELLED("2", "Gönderi iptal edildi. ");

    private final String code;
    private final String message;
    ShipmentLifecycleStatus(String code, String message){
        this.code=code;
        this.message=message;
    }
}

