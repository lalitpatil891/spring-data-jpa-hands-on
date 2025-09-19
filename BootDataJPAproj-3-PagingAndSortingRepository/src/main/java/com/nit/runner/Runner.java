package com.nit.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nit.entity.Doctor;
import com.nit.service.IDoctorService;

/**
 * Runner class to test Paging and Sorting functionality
 * using PagingAndSortingRepository (through JpaRepository).
 */
@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private IDoctorService service;

    @Override
    public void run(String... args) throws Exception {

        // ================== Sorting Examples ==================
        try {
            System.out.println("=== Sorting by single property (docName ASC) ===");
            service.showDoctorsBySorting(true, "docName").forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("============================================");

        try {
            System.out.println("=== Sorting by multiple properties (docName, income ASC) ===");
            service.showDoctorsBySorting(true, "docName", "income").forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ================== Pagination Example ==================
        try {
            System.out.println("=== Pagination Example (Page 0, Size 5, Sorted by docName ASC) ===");

            Page<Doctor> page = service.showDoctorsInfoByPageNo(0, 5, true, "docName");

            // Page metadata
            System.out.println("Page Number        : " + page.getNumber());
            System.out.println("Total Pages        : " + page.getTotalPages());
            System.out.println("Page Elements Count: " + page.getNumberOfElements());
            System.out.println("Is First Page?     : " + page.isFirst());
            System.out.println("Is Last Page?      : " + page.isLast());
            System.out.println("Page Size          : " + page.getSize());

            // Page content
            if (!page.isEmpty()) {
                List<Doctor> list = page.getContent();
                list.forEach(System.out::println);
            } else {
                System.out.println("No page found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("==============================================");

        // ================== Full Pagination Demo ==================
        service.showDataThroughPagiation(3);
    }
}
