package com.example.notaryofficeservice.repository;

import com.example.notaryofficeservice.model.RegistryOfficeDuties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistryOfficeDutyRepository extends JpaRepository<RegistryOfficeDuties, String> {
    boolean existsByName(String name);
}