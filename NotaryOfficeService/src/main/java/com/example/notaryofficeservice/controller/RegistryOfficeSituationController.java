package com.example.notaryofficeservice.controller;

import com.example.notaryofficeservice.model.RegistryOfficeSituations;
import com.example.notaryofficeservice.service.RegistryOfficeSituationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/situations")
public class RegistryOfficeSituationController {
    @Autowired
    private RegistryOfficeSituationService service;

    @GetMapping
    public List<RegistryOfficeSituations> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistryOfficeSituations> findById(@PathVariable String id) {
        RegistryOfficeSituations situation = service.findById(id);
        if (situation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(situation, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RegistryOfficeSituations> create(@Valid @RequestBody RegistryOfficeSituations situation) {
        return new ResponseEntity<>(service.save(situation), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistryOfficeSituations> update(@PathVariable String id, @Valid @RequestBody RegistryOfficeSituations situation) {
        if (service.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        situation.setId(id);
        return new ResponseEntity<>(service.save(situation), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}