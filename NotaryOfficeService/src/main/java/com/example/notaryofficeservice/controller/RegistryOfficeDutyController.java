package com.example.notaryofficeservice.controller;

import com.example.notaryofficeservice.model.RegistryOfficeDuties;
import com.example.notaryofficeservice.service.RegistryOfficeDutyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/duties")
public class RegistryOfficeDutyController {
    @Autowired
    private RegistryOfficeDutyService service;

    @GetMapping
    public List<RegistryOfficeDuties> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistryOfficeDuties> findById(@PathVariable String id) {
        RegistryOfficeDuties duty = service.findById(id);
        if (duty == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(duty, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RegistryOfficeDuties> create(@Valid @RequestBody RegistryOfficeDuties duty) {
        if (service.existsByName(duty.getName())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(service.save(duty), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistryOfficeDuties> update(@PathVariable String id, @Valid @RequestBody RegistryOfficeDuties duty) {
        if (service.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        duty.setId(id);
        return new ResponseEntity<>(service.save(duty), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}