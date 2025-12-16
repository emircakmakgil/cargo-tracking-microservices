package com.example.shipmentservice.controller;

import com.example.shipmentservice.data.dto.ContactDto.ContactListiningDto;
import com.example.shipmentservice.data.dto.ContactDto.CreateContactDto;
import com.example.shipmentservice.data.dto.ContactDto.DeleteContactDto;
import com.example.shipmentservice.data.dto.ContactDto.UpdateContactDto;
import com.example.shipmentservice.service.ContactService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/contact")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Get Contact information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ContactListiningDto.class)
                    )
            )
    })
    @GetMapping
    public List<ContactListiningDto> getAll() {
        return contactService.getAll();
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Add contact information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CreateContactDto.class)
                    )
            )
    })
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateContactDto createContactDto){
        contactService.add(createContactDto);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Update contact information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UpdateContactDto.class)
                    )
            )
    })
    @PutMapping
    public void update(@RequestBody UpdateContactDto updateContactDto) {
        contactService.update(updateContactDto);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Delete contact information",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = DeleteContactDto.class)
                    )
            )
    })
    @DeleteMapping
    public void delete(@RequestBody DeleteContactDto deleteContactDto) {
        contactService.delete(deleteContactDto  );
    }

}
