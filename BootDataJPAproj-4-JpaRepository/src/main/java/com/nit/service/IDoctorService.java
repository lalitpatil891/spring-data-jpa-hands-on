package com.nit.service;

import java.util.List;

import com.nit.entity.Doctor;

/**
 * Service interface defining business operations for Doctor entity.
 */
public interface IDoctorService {

    // ================= DELETE =================
    
    /**
     * Delete multiple doctors by their IDs in a single batch operation.
     * @param ids List of doctor IDs
     * @return String message indicating how many records were deleted
     */
    String deleteAllByIdInBatch(List<Integer> ids);

    // ================= FIND BY EXAMPLE =================
    
    /**
     * Find doctors matching the given example entity.
     * Allows sorting by specified properties.
     * @param exDoctor Example Doctor entity
     * @param ascOrder true for ascending, false for descending
     * @param properties Properties to sort by
     * @return List of doctors matching the example
     */
    List<Doctor> showDoctorsByExampleData(Doctor exDoctor, boolean ascOrder, String... properties);

    // ================= FIND BY ID =================
    
    /**
     * Find a doctor by ID using lazy loading.
     * @param id Doctor ID
     * @return Doctor entity
     */
    Doctor findDoctorById(Integer id);

    // ================= FIND BY NAME =================
    
    /**
     * Find doctors by name (exact match).
     * @param docName Doctor name
     * @return List of doctors with the given name
     */
    List<Doctor> findByName(String docName);
}
