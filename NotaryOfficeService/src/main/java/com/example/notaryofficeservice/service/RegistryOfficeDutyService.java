package com.example.notaryofficeservice.service;

import com.example.notaryofficeservice.model.RegistryOfficeDuties;
import com.example.notaryofficeservice.repository.RegistryOfficeDutyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistryOfficeDutyService {
    @Autowired
    private RegistryOfficeDutyRepository repository;

    public List<RegistryOfficeDuties> findAll() {
        return repository.findAll();
    }

    public RegistryOfficeDuties findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public RegistryOfficeDuties save(RegistryOfficeDuties duty) {
        return repository.save(duty);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }
}