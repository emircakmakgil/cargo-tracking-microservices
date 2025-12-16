package com.example.shipmentservice.rules;

import com.example.shipmentservice.core.exception.type.BusinessException;
import com.example.shipmentservice.data.entity.Address;
import com.example.shipmentservice.data.entity.Contact;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static com.example.shipmentservice.constant.GeneralConstant.*;

@Component
public class AddressBusinessRules {

    public void checkAddressFields(
            String city,
            String district,
            String addressLine) {

        if (city == null || city.isBlank()) {
            throw new BusinessException(CITY_REQUIRED);
        }

        if (district == null || district.isBlank()) {
            throw new BusinessException(DISTRICT_REQUIRED);
        }

        if (addressLine == null || addressLine.isBlank()) {
            throw new BusinessException(ADDRESS_LINE_REQUIRED);
        }
    }

    public void checkContactExists(Contact contact) {

        if (contact == null) {
            throw new BusinessException(CONTACT_NOT_FOUND);
        }
    }
    public void checkAddressAlreadyExists(boolean exists) {

        if (exists) {
            throw new BusinessException(ADDRESS_ALREADY_EXISTS);
        }
    }
    public void checkAddressUpdatable(Address address) {

        if (!Objects.equals(address.isDeleted(), "0")) {
            throw new BusinessException(DELETED_ADDRESS_CANNOT_BE_UPDATED);
        }
    }
    //TODO:IS_DEFAULT İÇİN GELİŞTİRME YAP
//    public void checkAddressDeletable(Address address) {
//
//        if (address.isDefault()) {
//            throw new BusinessException(DEFAULT_ADDRESS_CANNOT_BE_DELETED);
//        }
//    }
}
