package com.example.notaryofficeservice.repository;

import com.example.notaryofficeservice.model.RegistryOfficeSituations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistryOfficeSituationRepository extends JpaRepository<RegistryOfficeSituations, String> {
}