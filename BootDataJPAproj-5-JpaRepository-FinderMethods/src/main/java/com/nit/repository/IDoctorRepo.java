package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Doctor;

/**
 * Repository interface for Doctor entity.
 * Extends JpaRepository to get CRUD methods and
 * allows defining custom finder methods.
 */
public interface IDoctorRepo extends JpaRepository<Doctor, Integer> {

    // ------------------- Derived Query Methods -------------------

    // Exact match (case-sensitive)
    List<Doctor> findByDocName(String docName);

    // WHERE doc_name LIKE 'prefix%'
    Iterable<Doctor> findByDocNameStartingWith(String prefix);

    // WHERE doc_name LIKE '%suffix'
    Iterable<Doctor> findByDocNameEndingWith(String suffix);

    // WHERE doc_name LIKE '%keyword%'
    Iterable<Doctor> findByDocNameContaining(String keyword);

    // WHERE doc_name LIKE ? (full pattern passed, e.g., "%Mehta%")
    Iterable<Doctor> findByDocNameLike(String pattern);

    // WHERE LOWER(doc_name) = LOWER(?)
    Iterable<Doctor> findByDocNameEqualsIgnoreCase(String name);

    // WHERE LOWER(doc_name) LIKE LOWER('%keyword%')
    Iterable<Doctor> findByDocNameContainingIgnoreCase(String keyword);

    // WHERE doc_name IS NULL
    Iterable<Doctor> findByDocNameIsNull();

    // WHERE doc_name IS NOT NULL
    Iterable<Doctor> findByDocNameIsNotNull();

    // WHERE doc_name IN (...)
    Iterable<Doctor> findByDocNameIn(List<String> names);

    // WHERE doc_name NOT IN (...)
    Iterable<Doctor> findByDocNameNotIn(List<String> names);
}
