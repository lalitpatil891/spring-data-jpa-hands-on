package com.nit.service;

import java.util.List;
import java.util.Optional;

import com.nit.entity.Doctor;

/**
 * Service interface defining business operations for Doctor entity.
 */
public interface IDoctorService {

//    public List<Doctor> searchDoctorByIncomeRange(double startRange, double endRange);
    
    
    public List<Doctor> searchDoctorBySpecializations(String sp1, String sp2);
    
    public List<Object[]> searchDoctorDataByIncome(double start, double end);
    
    public List<String> searchAllDoctorsNameByIncomeRange(double min, double max);
    
    
	public Doctor showDoctorInfoByName(String name);
	
	public Object searchDoctorByNameDocName(String docName);
	
	public String searchSpecilizationByName(String docName);
}
