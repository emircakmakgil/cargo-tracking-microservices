package com.example.trackingservice.model.enums;

import lombok.Getter;
@Getter
public enum LocationType {

    WAREHOUSE("WH", "Depo"),
    TRANSFER_CENTER("TC", "Transfer Merkezi"),
    DELIVERY_UNIT("DU", "Dağıtım Birimi");

    private final String code;
    private final String description;

    LocationType(String code, String description) {
        this.code = code;
        this.description = description;
    }
}

