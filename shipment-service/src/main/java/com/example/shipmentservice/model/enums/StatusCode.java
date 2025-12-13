package com.example.shipmentservice.model.enums;

import lombok.Getter;

@Getter
public enum StatusCode {
    CREATED("1", "Gönderi oluşturuldu ve işlenmeyi bekliyor."),
    IN_TRANSIT("2", "Gönderi varış noktasına doğru taşınma sürecinde."),
    DELIVERED("3", "Gönderi alıcıya başarıyla teslim edildi.");

    private final String code;
    private final String message;
    StatusCode(String code,String message){
        this.code=code;
        this.message=message;
    }
}
