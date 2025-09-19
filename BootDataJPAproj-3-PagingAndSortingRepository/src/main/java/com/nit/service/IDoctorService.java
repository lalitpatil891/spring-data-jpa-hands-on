package com.nit.service;

import org.springframework.data.domain.Page;
import com.nit.entity.Doctor;

/**
 * Service interface for Doctor entity.
 * Provides methods for sorting and pagination.
 */
public interface IDoctorService {

    /**
     * Fetch all doctors sorted by given properties.
     * 
     * @param asc   true for ascending, false for descending
     * @param props properties to sort by
     * @return sorted doctors
     */
    Iterable<Doctor> showDoctorsBySorting(boolean asc, String... props);

    /**
     * Fetch doctors by a specific page number and size with sorting.
     * 
     * @param pageNo    page number (0-based)
     * @param pageSize  number of records per page
     * @param ascOrder  true for ascending, false for descending
     * @param props     property to sort by
     * @return a Page of doctors
     */
    Page<Doctor> showDoctorsInfoByPageNo(int pageNo, int pageSize, boolean ascOrder, String props);

    /**
     * Fetch and display all doctors through pagination.
     * 
     * @param pageSize number of records per page
     */
    void showDataThroughPagiation(int pageSize);
}
