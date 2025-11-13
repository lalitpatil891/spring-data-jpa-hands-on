package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.PhoneNumber;

public interface IPhoneNumberRepository extends JpaRepository<PhoneNumber, Integer> {
	

}
