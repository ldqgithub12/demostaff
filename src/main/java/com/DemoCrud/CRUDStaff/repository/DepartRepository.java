package com.DemoCrud.CRUDStaff.repository;

import com.DemoCrud.CRUDStaff.models.Departs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartRepository extends JpaRepository<Departs,String> {
}
