package com.example.shipmentservice.data.dto.AddressDto;

import com.example.shipmentservice.model.enums.AddressType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressListiningDto {
    private String street;
    private String buildingNumber;
    private String apartmentNumber;
    private String district;
    private String city;
    private String country;
    private String zipCode;
    private AddressType addressType;

    public AddressListiningDto(@NotBlank(message = "Street is required") String street, String buildingNumber, String apartmentNumber, String district, @NotBlank(message = "City is required") String city, @NotBlank(message = "Country is required") String country, @NotBlank(message = "Zip code is required") @Pattern(regexp = "^[0-9]{5,10}$", message = "Zip code must be 5-10 digits") String zipCode, AddressType addressType) {
        this.street=street;
        this.buildingNumber=buildingNumber;
        this.apartmentNumber=apartmentNumber;
        this.district=district;
        this.city=city;
        this.country=country;
        this.zipCode=zipCode;
        this.addressType=addressType;
    }
}
