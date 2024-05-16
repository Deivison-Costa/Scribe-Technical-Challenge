package com.example.notaryofficeservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class NotaryOffices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Positive
    private int id;

    @Size(max = 150)
    @NotBlank
    private String name;

    @Size(max = 250)
    private String note;

    @ManyToOne
    @JoinColumn(name = "status", nullable = false)
    private RegistryOfficeSituations status;

    @ManyToMany
    @JoinTable(
            name = "notary_office_duties",
            joinColumns = @JoinColumn(name = "notary_office_id"),
            inverseJoinColumns = @JoinColumn(name = "duty_id")
    )
    private List<RegistryOfficeDuties> duties;
}