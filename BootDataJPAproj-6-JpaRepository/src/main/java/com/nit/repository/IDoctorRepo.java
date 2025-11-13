package com.nit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nit.entity.Doctor;

/**
 * Repository interface for Doctor entity.
 * Extends JpaRepository to provide CRUD and JPA operations.
 */
public interface IDoctorRepo extends JpaRepository<Doctor, Integer> {
	
	/* 	@Query("FROM Doctor WHERE income >=:start AND income <=:end")
		public List<Doctor> searchDoctorsByIncomeRange(@Param("start") double startRange,@Param("end") double endRange);
	*/

	/*	@Query("SELECT doc FROM Doctor doc WHERE doc.income >= ?1 AND doc.income <= ?2") //NOTE: no space between ?1 and AND.
		public List<Doctor> searchDoctorsByIncomeRange(double startRange, double endRange);
	*/	
	
	/*	@Query("FROM Doctor WHERE income >= :startRange AND income <= :endRange")
		public List<Doctor> searchDoctorsByIncomeRange(double startRange, double endRange);
	*/
	
	/*----------------------------------------------------*/
	
	//select -Entity Query
	@Query("FROM Doctor WHERE specialization IN(:sp1, :sp2) ORDER BY specialization")
	public List<Doctor> searchDoctorBySpecializations(@Param("sp1") String sp1,
	                                                  @Param("sp2") String sp2);
	
	//Select -- Projection Query with specific  multiple col  values 
	@Query("SELECT docid, docName, income FROM Doctor WHERE income between :start and :end")
	public List<Object[]> searchDoctorDataByIncome(double start, double end);
	
	//Select -- Projection Query with specific sigle col values
	@Query("SELECT docName FROM Doctor WHERE income between :min and :max")
	public List<String> searchAllDoctorsNameByIncomeRange(double min, double max);
	
	
	/*----------------------------------------------------*/
	
	//Entity query giving single record
	@Query("FROM Doctor	WHERE docName=:name")
	public Optional<Doctor> showDoctorInfoByName(String name);  
	
	
	//Scalar Query giving single record multiple col values
	@Query("SELECT docid, docName FROM Doctor WHERE docName = :name")
	public Object showDoctorDataByName(String name);

	
	@Query("SELECT specialization FROM Doctor WHERE docName = :name")
	public String showSpecializationByName(String name);

	
}
