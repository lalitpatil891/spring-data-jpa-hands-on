package com.nit.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Doctor;
import com.nit.service.IDoctorService;

/** Runner class to test DoctorService methods when Spring Boot application
 * starts. Implements CommandLineRunner. */
@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private IDoctorService service;

	@Override
	public void run(String... args) throws Exception {

		// service.searchDoctorByIncomeRange(80000,
		// 100000).forEach(System.out::println);
		/*
				// ------------
				service.searchDoctorBySpecializations("Orthopedic", "Neurologist").forEach(System.out::println);
				System.out.println("===================");
				// ------------
				service.searchDoctorDataByIncome(80000.0, 100000.0).forEach(row -> {
					for (Object obj : row) {
						System.out.print(obj + " ");
					}
					System.out.println();
				});
		
				System.out.println("===================");
				// -------------
				service.searchDoctorDataByIncome(80000.0, 100000.0).forEach(row -> {
					System.out.println(Arrays.toString(row));
				});
		
				System.out.println("===================");
				// ------------
		
				service.searchAllDoctorsNameByIncomeRange(80000, 100000).forEach(System.out::println);
				// ------------
				*/
		Doctor doc = service.showDoctorInfoByName("Dr. Kavita Nair");
		System.out.println(doc.getDocName());
		System.out.println("Doctor Info: "+doc);
		
		System.out.println("______________________________");
		Object obj = service.searchDoctorByNameDocName("raja");

		if (obj != null) {
		    Object data[] = (Object[]) obj;
		    for (Object o : data) {
		        System.out.print(o + "  ");
		    }
		    System.out.println();
		    System.out.println("Result is ::" + Arrays.toString(data));
		} else {
		    System.out.println("❌ No doctor found with the given name!");
		}

		System.out.println("______________________________");

		String result = service.searchSpecilizationByName("raja");
		System.out.println("specialization is ::" + result);

		

	}
}
