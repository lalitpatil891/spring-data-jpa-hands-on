package com.nit.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.repository.IDoctorRepo;

/**
 * Runner class used to test DoctorRepository methods
 * when the Spring Boot application starts.
 * Implements CommandLineRunner.
 */
@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private IDoctorRepo doctorRepo;

    @Override
    public void run(String... args) throws Exception {

        // ================== FIND BY NAME ==================
        // Exact match (case-sensitive)
        // doctorRepo.findByDocName("Dr. Priya Mehta").forEach(System.out::println);

        // Starts with prefix (e.g., Dr. Kav...)
        // doctorRepo.findByDocNameStartingWith("Dr. Kav").forEach(System.out::println);

        // Ends with suffix (e.g., ...Khan)
        // doctorRepo.findByDocNameEndingWith("Khan").forEach(System.out::println);

        // Contains substring (case-sensitive)
        // doctorRepo.findByDocNameContaining("ali").forEach(System.out::println);

        // Like query with wildcards (%)
        // doctorRepo.findByDocNameLike("%Gupta%").forEach(System.out::println);

        // Exact match but case-insensitive
        // doctorRepo.findByDocNameEqualsIgnoreCase("dr. priya mehta").forEach(System.out::println);

        // Contains substring but case-insensitive
        // doctorRepo.findByDocNameContainingIgnoreCase("k").forEach(System.out::println);

        // NOT NULL check
        // doctorRepo.findByDocNameIsNotNull().forEach(System.out::println);

        // NULL check
        // doctorRepo.findByDocNameIsNull().forEach(System.out::println);

        // IN clause example
        // doctorRepo.findByDocNameIn(List.of("Dr. Priya Mehta", "Dr. Kavita Nair")).forEach(System.out::println);

        // NOT IN clause example
        doctorRepo.findByDocNameNotIn(List.of("Dr. Anjali Patil")).forEach(System.out::println);
    }
}
