package com.nit.service;

import java.util.List;
import java.util.Optional;

import com.nit.entity.Doctor;

/**
 * Service interface that defines CRUD operations for Doctor entity.
 */
public interface IDoctorService {

    // Create
    String registerDoctor(Doctor doctor);
    String registerDoctorsBatch(List<Doctor> list);

    // Read
    long showDoctorsCount();
    boolean isDoctorAvailable(int id);
    Iterable<Doctor> showAllDoctors();
    Iterable<Doctor> findDoctorsById(Iterable<Integer> ids);
    Doctor findDoctorById(int id);
    Optional<Doctor> showDoctorById(int id);

    // Update
    String updateDoctorName(int id, String name);

    // Delete
    String delateDoctorById(int id);
    String deleteDoctorByEntity(Doctor doctor);
    String removeAllDoctors();
    String removeDoctorsByIds(Iterable<Integer> ids);
}
