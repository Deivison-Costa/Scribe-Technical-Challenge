package com.example.notaryofficeservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class RegistryOfficeSituations {
    @Id
    @Size(max = 20)
    @NotBlank
    private String id;

    @Size(max = 50)
    @NotBlank
    private String name;
}