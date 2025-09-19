package com.nit.runner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Doctor;
import com.nit.service.IDoctorService;

/**
 * Runner class to test various CRUD operations 
 * provided by the IDoctorService using CrudRepository.
 */
@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private IDoctorService service;

    @Override
    public void run(String... args) throws Exception {

        /* ======================== CREATE OPERATIONS ======================== */

        // Register a single doctor
        /*
        try {
            Doctor doctor = new Doctor();
            doctor.setDocName("Sunil");
            doctor.setSpecialization("Ortho");
            doctor.setIncome(40000.0);

            String resultMsg = service.registerDoctor(doctor);
            System.out.println(resultMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        // Register a batch of doctors
        /*
        try {
            List<Doctor> doctorList = List.of(
                    new Doctor("Dr. Mayur Pawar", "Cardiologist", 40000.0),
                    new Doctor("Dr. Lalit Patil", "Cardiologist", 60000.0),
                    new Doctor("Dr. Rupesh Modi", "Cardiologist", 80000.0),
                    new Doctor("Dr. Yogesh Mali", "Cardiologist", 70000.0)
            );
            String msg = service.registerDoctorsBatch(doctorList);
            System.out.println(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */


        /* ======================== READ OPERATIONS ======================== */

        // Count doctors
        /*
        try {
            long count = service.showDoctorsCount();
            System.out.println("Total Doctor Count is: " + count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        // Check doctor availability
        /*
        try {
            boolean isAvailable = service.isDoctorAvailable(13);
            System.out.println(isAvailable ? "Doctor is Available" : "Doctor is not Available");
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        // Show all doctors
        /*
        try {
            Iterable<Doctor> doctorsList = service.showAllDoctors();
            doctorsList.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        // Find doctors by multiple IDs
        /*
        try {
            service.findDoctorsById(List.of(1, 2, 4)).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        // Find doctor by ID (single record)
        /*
        try {
            Doctor doctor = service.findDoctorById(2);
            System.out.println(doctor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        // Find doctor by ID (Optional)
        /*
        try {
            Optional<Doctor> doctor = service.showDoctorById(2);
            doctor.ifPresent(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */


        /* ======================== UPDATE OPERATION ======================== */

        /*
        try {
            String isUpdated = service.updateDoctorName(3, "Dr. Murlidar Patil");
            System.out.println(isUpdated);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */


        /* ======================== DELETE OPERATIONS ======================== */

        // Delete doctor by ID
        /*
        try {
            String isDeleted = service.delateDoctorById(4);
            System.out.println(isDeleted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        // Delete doctor by entity
        /*
        try {
            Doctor dr = new Doctor(1, "Dr. Mayur Pawar", "Cardiologist", 40000.0);
            System.out.println(service.deleteDoctorByEntity(dr));
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        // Delete all doctors
        /*
        try {
            System.out.println(service.removeAllDoctors());
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        // Delete multiple doctors by IDs
        try {
            String msg = service.removeDoctorsByIds(List.of(6, 7, 8));
            System.out.println(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
