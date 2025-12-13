package com.example.shipmentservice.model.enums;

import lombok.Getter;

@Getter
public enum PackageFeature {
    FRAGILE("FRG", "Kırılabilir ürün taşıyan paket"),
    LIQUID("LIQ", "Sıvı içeren paket"),
    ELECTRONICS("ELE", "Elektronik cihaz paketi"),
    PERISHABLE("PER", "Bozulabilir / özel saklama gerektiren ürün");

    private final String code;
    private final String description;

    PackageFeature(String code, String description) {
        this.code = code;
        this.description = description;
    }
}