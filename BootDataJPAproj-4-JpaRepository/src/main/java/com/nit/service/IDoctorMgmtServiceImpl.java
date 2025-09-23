package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nit.entity.Doctor;
import com.nit.repository.IDoctorRepo;

import jakarta.transaction.Transactional;

/**
 * Implementation of IDoctorService providing business logic
 * for Doctor entity operations using Spring Data JPA.
 */
@Service("doctorService")
public class IDoctorMgmtServiceImpl implements IDoctorService {

    @Autowired
    private IDoctorRepo doctorRepo;

    // ================= DELETE =================
    @Override
    public String deleteAllByIdInBatch(List<Integer> ids) {
        // First fetch doctors to count how many exist
        List<Doctor> list = doctorRepo.findAllById(ids);

        // Perform batch deletion
        doctorRepo.deleteAllByIdInBatch(ids);
        return list.size() + " record(s) deleted successfully!";
    }

    // ================= FIND BY EXAMPLE =================
    @Override
    public List<Doctor> showDoctorsByExampleData(Doctor exDoctor, boolean ascOrder, String... properties) {
        Sort sort = Sort.by(ascOrder ? Direction.ASC : Direction.DESC, properties);
        Example<Doctor> example = Example.of(exDoctor);  // Create example probe
        return doctorRepo.findAll(example, sort);         // Find all matching example
    }

    // ================= FIND BY ID =================
    @Override
    @Transactional
    public Doctor findDoctorById(Integer id) {
        // Lazy loading using getReferenceById
        Doctor doc = doctorRepo.getReferenceById(id);

        // Forces initialization of lazy-loaded object
        System.out.println(doc.getDocName());
        return doc;
    }

    // ================= FIND BY NAME =================
    @Override
    public List<Doctor> findByName(String docName) {
        return doctorRepo.findByDocName(docName);
    }
}
