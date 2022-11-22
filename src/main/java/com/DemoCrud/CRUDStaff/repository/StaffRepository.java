package com.DemoCrud.CRUDStaff.repository;

import com.DemoCrud.CRUDStaff.models.Staffs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staffs,Integer> {
}
