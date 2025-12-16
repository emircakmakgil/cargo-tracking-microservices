package com.example.trackingservice.model.enums;

import lombok.Getter;

@Getter
public enum TrackingStatusCode {

    CREATED("1", "Gönderi oluşturuldu"),
    IN_TRANSIT("2", "Taşınma sürecinde"),
    AT_TRANSFER_CENTER("3", "Transfer merkezinde"),
    OUT_FOR_DELIVERY("4", "Dağıtıma çıktı"),
    DELIVERED("5", "Teslim edildi"),
    RETURNED("6", "İade edildi");

    private final String code;
    private final String message;


    TrackingStatusCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
