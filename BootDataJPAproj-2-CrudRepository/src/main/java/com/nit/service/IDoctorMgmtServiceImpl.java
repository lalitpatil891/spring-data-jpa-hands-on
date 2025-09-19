package com.nit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Doctor;
import com.nit.repository.IDoctorRepo;

import jakarta.transaction.Transactional;

/**
 * Service implementation class that provides
 * CRUD logic for Doctor entity using CrudRepository.
 */
@Service("doctorService")
public class IDoctorMgmtServiceImpl implements IDoctorService {

    @Autowired
    private IDoctorRepo doctorRepo;

    /* ======================== CREATE ======================== */

    @Override
    public String registerDoctor(Doctor doctor) {
        return "Doctor saved with ID: " + doctorRepo.save(doctor).getDocid();
    }

    @Override
    @Transactional
    public String registerDoctorsBatch(List<Doctor> list) {
        if (list == null || list.isEmpty()) {
            return "No doctors to register!";
        }
        Iterable<Doctor> savedIterable = doctorRepo.saveAll(list);
        List<Doctor> savedList = StreamSupport.stream(savedIterable.spliterator(), false)
                                              .collect(Collectors.toList());
        return savedList.size() + " doctors registered successfully!";
    }


    /* ======================== READ ======================== */

    @Override
    public long showDoctorsCount() {
        return doctorRepo.count();
    }

    @Override
    public boolean isDoctorAvailable(int id) {
        return doctorRepo.existsById(id);
    }

    @Override
    public Iterable<Doctor> showAllDoctors() {
        return doctorRepo.findAll();
    }

    @Override
    public Iterable<Doctor> findDoctorsById(Iterable<Integer> ids) {
        return doctorRepo.findAllById(ids);
    }

    @Override
    public Doctor findDoctorById(int id) {
        return doctorRepo.findById(id)
                         .orElseThrow(() -> new IllegalArgumentException("Invalid Doctor ID"));
    }

    @Override
    public Optional<Doctor> showDoctorById(int id) {
        return doctorRepo.findById(id);
    }


    /* ======================== UPDATE ======================== */

    @Override
    public String updateDoctorName(int id, String name) {
        Optional<Doctor> doc = doctorRepo.findById(id);

        if (doc.isPresent()) {
            String beforeName = doc.get().getDocName();
            doc.get().setDocName(name);
            doctorRepo.save(doc.get());
            return "Doctor name updated: " + beforeName + " -> " + name;
        } else {
            return "Invalid ID";
        }
    }


    /* ======================== DELETE ======================== */

    @Override
    public String delateDoctorById(int id) {
        Optional<Doctor> doctor = doctorRepo.findById(id);

        if (doctor.isPresent()) {
            doctorRepo.deleteById(id);
            return "Doctor deleted successfully.";
        } else {
            return "Invalid ID";
        }
    }

    @Override
    public String deleteDoctorByEntity(Doctor doctor) {
        int docId = doctor.getDocid();
        Optional<Doctor> dr = doctorRepo.findById(docId);

        if (dr.isPresent()) {
            doctorRepo.delete(doctor);
            return "Doctor deleted successfully.";
        } else {
            return "Doctor not found!";
        }
    }

    @Override
    public String removeAllDoctors() {
        if (doctorRepo.count() != 0) {
            doctorRepo.deleteAll();
            return "All doctor records are deleted.";
        } else {
            return "No records found for deletion!";
        }
    }

    @Override
    public String removeDoctorsByIds(Iterable<Integer> ids) {
        Iterable<Doctor> doctors = doctorRepo.findAllById(ids);
        long count = StreamSupport.stream(doctors.spliterator(), false).count();

        if (count != 0) {
            doctorRepo.deleteAllById(ids);
            return count + " doctor records deleted successfully!";
        } else {
            return "No doctor records found for deletion!";
        }
    }
}