package com.depdemo.depservice.repository;

import com.depdemo.depservice.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepmentRepository extends JpaRepository<Department,Long> {

    Department findByDepartmentId(Long departmentId);
    
}
