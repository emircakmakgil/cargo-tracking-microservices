package com.example.shipmentservice.data.dto.ContactDto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ContactListiningDto {
    private String fullName;
    private String phoneNumber;
    private String email;

    public ContactListiningDto(@NotBlank(message = "Full name is required") String fullName, @NotBlank(message = "Phone number is required") @Pattern(regexp = "^[0-9]{10,15}$", message = "Phone number must be 10-15 digits") String phoneNumber, @Email(message = "Email must be valid") String email) {
        this.fullName=fullName;
        this.phoneNumber=phoneNumber;
        this.email=email;
    }
}
