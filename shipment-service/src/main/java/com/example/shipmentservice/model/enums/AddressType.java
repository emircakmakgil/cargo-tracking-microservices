package com.example.shipmentservice.model.enums;

public enum AddressType {

    HOME("HOME", "Ev adresi"),
    WORK("WORK", "İş adresi"),
    BILLING("BILL", "Fatura adresi"),
    SHIPPING("SHIP", "Kargo teslimat adresi"),
    PICKUP("PICK", "Teslim alma noktası");

    private final String code;
    private final String description;

    AddressType(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
