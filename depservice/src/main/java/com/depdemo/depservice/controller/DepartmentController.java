package com.depdemo.depservice.controller;

import java.util.List;

import com.depdemo.depservice.entity.Department;
import com.depdemo.depservice.services.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import  org.slf4j.Logger;
import lombok.extern.slf4j.Slf4j;



@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    Logger log = org.slf4j.LoggerFactory.getLogger(DepartmentController.class);

    @GetMapping("/ping")
    public String ping(){
        log.info("inside ping-pong checking of departmentController");
        return "pong";
    }
    @PostMapping("/save")
    public Department saveDepartment(@RequestBody Department department){
        log.info("inside save department of departmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/find/{id}")
    public Department findDepartmentById(@PathVariable("id") Long depId){
        log.info("inside find department of departmentController");

        return departmentService.findDepartmentById(depId);
    }
    @GetMapping("/all")
    public List<Department> findAllDepartments(){
        return departmentService.findAllDepartments();
    }
}
