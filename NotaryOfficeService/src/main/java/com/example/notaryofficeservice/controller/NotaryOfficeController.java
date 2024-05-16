package com.example.notaryofficeservice.controller;

import com.example.notaryofficeservice.model.NotaryOffices;
import com.example.notaryofficeservice.service.NotaryOfficeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notary-offices")
public class NotaryOfficeController {
    @Autowired
    private NotaryOfficeService service;

    @GetMapping
    public Page<NotaryOffices> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return service.findAll(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotaryOffices> findById(@PathVariable int id) {
        NotaryOffices notaryOffice = service.findById(id);
        if (notaryOffice == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(notaryOffice, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NotaryOffices> create(@Valid @RequestBody NotaryOffices notaryOffice) {
        List<NotaryOffices> existingOffices = service.findByName(notaryOffice.getName());
        if (!existingOffices.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(service.save(notaryOffice), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotaryOffices> update(@PathVariable int id, @Valid @RequestBody NotaryOffices notaryOffice) {
        if (service.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        notaryOffice.setId(id);
        return new ResponseEntity<>(service.save(notaryOffice), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
