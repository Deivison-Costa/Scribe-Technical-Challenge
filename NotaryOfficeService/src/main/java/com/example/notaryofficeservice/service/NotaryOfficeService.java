package com.example.notaryofficeservice.service;

import com.example.notaryofficeservice.model.NotaryOffices;
import com.example.notaryofficeservice.repository.NotaryOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaryOfficeService {
    @Autowired
    private NotaryOfficeRepository repository;

    public Page<NotaryOffices> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    public NotaryOffices findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public NotaryOffices save(NotaryOffices notaryOffice) {
        return repository.save(notaryOffice);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public List<NotaryOffices> findByName(String name) {
        return repository.findByName(name);
    }
}