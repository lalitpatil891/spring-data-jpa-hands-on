package com.nit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Doctor;
import com.nit.service.IDoctorService;

import java.util.List;

/**
 * Runner class to test DoctorService methods when Spring Boot application starts.
 * Implements CommandLineRunner.
 */
@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private IDoctorService service;

    @Override
    public void run(String... args) throws Exception {

        // ================== DELETE EXAMPLES ==================
        /*
        System.out.println(service.deleteAllByIdInBatch(List.of(15,16,17)));
        System.out.println(service.deleteAllByIdInBatch(List.of(5,null))); // works with Arrays.asList
        */

        // ================== FIND BY EXAMPLE ==================
        /*
        Doctor exampleDoctor = new Doctor();
        exampleDoctor.setSpecialization("Dermatologist");
        exampleDoctor.setIncome(95000.0);

        service.showDoctorsByExampleData(exampleDoctor, true, "income")
               .forEach(System.out::println);
        */

        // ================== FIND BY ID ==================
        // System.out.println(service.findDoctorById(18));

        // ================== FIND BY NAME ==================
        service.findByName("Dr. priya mehta").forEach(System.out::println);
    }
}
