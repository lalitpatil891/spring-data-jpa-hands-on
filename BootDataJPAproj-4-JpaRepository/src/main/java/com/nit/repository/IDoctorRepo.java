package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Doctor;

/**
 * Repository interface for Doctor entity.
 * Extends JpaRepository to provide CRUD and JPA operations.
 */
public interface IDoctorRepo extends JpaRepository<Doctor, Integer> {

    /**
     * Find doctors by exact name.
     */
    List<Doctor> findByDocName(String docName);
}
