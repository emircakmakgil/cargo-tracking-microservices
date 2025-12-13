package com.example.shipmentservice.model.enums;


import lombok.Getter;

@Getter
public enum PackageType {

    BOX("BOX", "Standart karton kutu"),
    ENVELOPE("ENV", "Belge veya küçük evrak zarfı"),
    PALLET("PLT", "Paletli büyük yük"),
    TUBE("TUB", "Silindirik tüp paket"),
    CRATE("CRT", "Ağır eşyalar için ahşap sandık"),
    BAG("BAG", "Yumuşak çanta/paket"),
    OVERSIZED("OVR", "Aşırı büyük veya düzensiz şekilli paket");

    private final String code;
    private final String description;

    PackageType(String code, String description) {
        this.code = code;
        this.description = description;
    }
}

