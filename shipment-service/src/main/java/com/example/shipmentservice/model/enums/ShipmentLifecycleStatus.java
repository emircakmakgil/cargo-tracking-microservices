package com.example.shipmentservice.model.enums;

import lombok.Getter;

@Getter
public enum ShipmentLifecycleStatus {
    CREATED("1", "Gönderi oluşturuldu ve işlenmeyi bekliyor."),
    CANCELLED("2", "Gönderi iptal edildi. "),
    IN_TRANSIT("3","Gönderi yola çıkmıştır."),
    DELIVERED("4","Gönderi teslim edilmiştir.");

    private final String code;
    private final String message;
    ShipmentLifecycleStatus(String code, String message){
        this.code=code;
        this.message=message;
    }
}


