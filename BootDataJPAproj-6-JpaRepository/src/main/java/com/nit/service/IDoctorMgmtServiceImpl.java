package com.nit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Doctor;
import com.nit.repository.IDoctorRepo;

/** Implementation of IDoctorService providing business logic for Doctor entity
 * operations using Spring Data JPA. */
@Service("doctorService")
public class IDoctorMgmtServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepo doctorRepo;

	/* @Override
	public List<Doctor> searchDoctorByIncomeRange(double startRange, double endRange) {
		
		return doctorRepo.searchDoctorsByIncomeRange(startRange, endRange);
	}
	*/

	@Override
	public List<Doctor> searchDoctorBySpecializations(String sp1, String sp2) {
		// use repo
		List<Doctor> list = doctorRepo.searchDoctorBySpecializations(sp1, sp2);
		return list;
	}

	@Override
	public List<Object[]> searchDoctorDataByIncome(double start, double end) {
		List<Object[]> list = doctorRepo.searchDoctorDataByIncome(start, end);
		return list;
	}

	@Override
	public List<String> searchAllDoctorsNameByIncomeRange(double min, double max) {
		// use repo
		List<String> list = doctorRepo.searchAllDoctorsNameByIncomeRange(min, max);
		return list;
	}

	@Override
	public Doctor showDoctorInfoByName(String name) {
		Doctor doc = doctorRepo.showDoctorInfoByName(name)
				.orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
		return doc;
	}

	@Override
	public Object searchDoctorByNameDocName(String docName) {
		Object obj = doctorRepo.showDoctorDataByName(docName);
		return obj;
	}

	@Override
	public String searchSpecilizationByName(String docName) {
		String result = doctorRepo.showSpecializationByName(docName);
		return result;
	}

}
