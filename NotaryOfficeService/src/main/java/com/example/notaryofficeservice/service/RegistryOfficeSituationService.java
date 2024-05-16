package com.example.notaryofficeservice.service;

import com.example.notaryofficeservice.model.RegistryOfficeSituations;
import com.example.notaryofficeservice.repository.RegistryOfficeSituationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistryOfficeSituationService {
    @Autowired
    private RegistryOfficeSituationRepository repository;

    public List<RegistryOfficeSituations> findAll() {
        return repository.findAll();
    }

    public RegistryOfficeSituations findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public RegistryOfficeSituations save(RegistryOfficeSituations situation) {
        return repository.save(situation);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}