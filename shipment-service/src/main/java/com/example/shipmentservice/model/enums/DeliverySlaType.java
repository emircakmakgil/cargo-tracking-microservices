package com.example.shipmentservice.model.enums;

import lombok.Getter;

@Getter
public enum DeliverySlaType {

    SAME_DAY("SLA_SAME_DAY", "Aynı gün içinde teslimat garantisi"),
    NEXT_DAY("SLA_NEXT_DAY", "Ertesi gün teslimat garantisi"),
    TWO_DAY("SLA_2_DAY", "2 gün içinde teslimat garantisi"),
    THREE_DAY("SLA_3_DAY", "3 gün içinde teslimat garantisi"),
    STANDARD("SLA_STANDARD", "Standart teslimat (3-7 gün arası)"),
    EXPRESS("SLA_EXPRESS", "Hızlı teslimat (1-2 gün arası)"),
    ECONOMY("SLA_ECONOMY", "Ekonomik teslimat (uzun süreli, düşük maliyetli)"),
    INTERNATIONAL_EXPRESS("SLA_INTL_EXPRESS", "Uluslararası hızlı teslimat"),
    INTERNATIONAL_STANDARD("SLA_INTL_STD", "Uluslararası standart teslimat"),
    INTERNATIONAL_ECONOMY("SLA_INTL_ECO", "Uluslararası ekonomik teslimat");

    private final String code;
    private final String description;

    DeliverySlaType(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
