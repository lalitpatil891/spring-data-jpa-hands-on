//IDoctorRepo.java
package com.nit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nit.entity.Doctor;

public interface IDoctorRepo extends PagingAndSortingRepository<Doctor, Integer>, CrudRepository<Doctor, Integer> {
	
}
