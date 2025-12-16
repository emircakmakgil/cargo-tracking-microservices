package com.example.shipmentservice.rules;

import com.example.shipmentservice.core.exception.type.BusinessException;
import com.example.shipmentservice.data.entity.Contact;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static com.example.shipmentservice.constant.GeneralConstant.*;

//TODO:EKLE BURAYA
@Component
public class ContractBusinessRules {

    public void checkCreateContractRequirements(
                Contact contact,
                LocalDate startDate,
                LocalDate endDate) {

            if (contact == null) {
                throw new BusinessException(CONTACT_NOT_FOUND);
            }

            if (startDate == null) {
                throw new BusinessException(CONTRACT_START_DATE_REQUIRED);
            }

            if (endDate == null) {
                throw new BusinessException(CONTRACT_END_DATE_REQUIRED);
            }

            if (endDate.isBefore(startDate)) {
                throw new BusinessException(INVALID_CONTRACT_DATE_RANGE);
            }
        }
    public void checkSingleActiveContract(boolean hasActiveContract) {

        if (hasActiveContract) {
            throw new BusinessException(ACTIVE_CONTRACT_ALREADY_EXISTS);
        }
    }


}
