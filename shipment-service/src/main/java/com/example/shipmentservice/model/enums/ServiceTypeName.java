package com.example.shipmentservice.model.enums;

import lombok.Getter;

@Getter
public enum ServiceTypeName {
    STANDARD("STD", "Standart teslimat hizmeti (normal gönderim süresi)"),
    EXPRESS("EXP", "Hızlı ekspres teslimat hizmeti"),
    SAME_DAY("SMD", "Aynı gün teslimat hizmeti"),
    NEXT_DAY("NXD", "Ertesi gün garantili teslimat"),
    INTERNATIONAL("INT", "Uluslararası gönderi hizmeti"),
    ECONOMY("ECN", "Ekonomik, daha yavaş teslimat seçeneği"),
    DOOR_TO_DOOR("DTD", "Kapıdan kapıya alma ve teslimat"),
    PICKUP_POINT("PUP", "Müşteri teslim alma noktasına gönderi"),
    INSURED("INS", "Beyan edilen değer için sigortalı gönderi"),
    COLD_CHAIN("CLD", "Sıcaklık kontrollü soğuk zincir taşımacılığı"),
    HEAVY_CARGO("HVC", "Ağır ve büyük hacimli kargo hizmeti"),
    RETURN_SERVICE("RTN", "İade gönderi hizmeti");


    private final String code;
    private final String description;

    ServiceTypeName(String code, String description) {
        this.code = code;
        this.description = description;
    }

}
