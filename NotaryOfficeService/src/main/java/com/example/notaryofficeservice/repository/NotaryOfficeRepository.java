package com.example.notaryofficeservice.repository;

import com.example.notaryofficeservice.model.NotaryOffices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotaryOfficeRepository extends JpaRepository<NotaryOffices, Integer> {
    @Query("SELECT n FROM NotaryOffices n WHERE n.name = :name")
    List<NotaryOffices> findByName(@Param("name") String name);
}