package com.example.shipmentservice.model.enums;

import lombok.Getter;

@Getter
public enum LocationType {
    HUB("HUB", "Ana dağıtım merkezi"),
    BRANCH("BRH", "Yerel şube"),
    DELIVERY_CENTER("DLC", "Kurye teslimat merkezi"),
    WAREHOUSE("WRH", "Depo ve stok yönetim alanı"),
    CUSTOMS("CSTM", "Gümrük kontrol merkezi"),
    AIRPORT("AIR", "Havalimanı kargo tesisi"),
    PORT("PRT", "Liman kargo terminali"),
    LINEHAUL_CENTER("LHC", "Şehirler arası aktarma merkezi");

    private final String code;
    private final String description;
    LocationType(String code,String description){
        this.code=code;
        this.description=description;
    }

}
