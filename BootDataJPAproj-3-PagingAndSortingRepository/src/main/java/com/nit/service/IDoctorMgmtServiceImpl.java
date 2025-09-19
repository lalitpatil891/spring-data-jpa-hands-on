package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nit.entity.Doctor;
import com.nit.repository.IDoctorRepo;

/**
 * Service implementation class for Doctor entity.
 * Uses PagingAndSortingRepository (through JpaRepository) features.
 */
@Service("doctorService")
public class IDoctorMgmtServiceImpl implements IDoctorService {

    @Autowired
    private IDoctorRepo doctorRepo;

    /**
     * Show doctors sorted by given properties.
     */
    @Override
    public Iterable<Doctor> showDoctorsBySorting(boolean asc, String... props) {
        Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, props);
        return doctorRepo.findAll(sort);
    }

    /**
     * Show doctors by page number, page size and sorting.
     */
    @Override
    public Page<Doctor> showDoctorsInfoByPageNo(int pageNo, int pageSize, boolean ascOrder, String props) {
        Sort sort = Sort.by(ascOrder ? Direction.ASC : Direction.DESC, props);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return doctorRepo.findAll(pageable);
    }

    /**
     * Display all doctors using pagination with the given page size.
     */
    @Override
    public void showDataThroughPagiation(int pageSize) {
        long count = doctorRepo.count();
        long pagesCount = count / pageSize;

        if (count % pageSize != 0)
            pagesCount++;

        for (int i = 0; i < pagesCount; ++i) {
            Pageable pageable = PageRequest.of(i, pageSize);
            Page<Doctor> page = doctorRepo.findAll(pageable);

            System.out.println("Page " + (page.getNumber() + 1) + " of " + page.getTotalPages());
            page.getContent().forEach(System.out::println);
            System.out.println("-----------------------------------------------------");
        }
    }
}