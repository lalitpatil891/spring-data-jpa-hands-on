package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Person;

public interface IPersonRepository extends JpaRepository<Person, Integer> {

}
