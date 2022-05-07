package com.depdemo.depservice.services;

import java.util.List;

import com.depdemo.depservice.entity.Department;
import com.depdemo.depservice.repository.DepmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {
  @Autowired
  private DepmentRepository depmentRepository;

  Logger log = org.slf4j.LoggerFactory.getLogger(DepartmentService.class);

  public Department saveDepartment(Department dep) {
    log.info("inside of saveDepartment in DepartmentService");
    return depmentRepository.save(dep);
  }

  public Department findDepartmentById(Long depId) {
    log.info("inside of findDepartmentById in DepartmentService");

    return depmentRepository.findByDepartmentId(depId);
  }

public List<Department> findAllDepartments() {
  log.info("inside of find all departmentsin DepartmentService");

    return depmentRepository.findAll();
}
}
