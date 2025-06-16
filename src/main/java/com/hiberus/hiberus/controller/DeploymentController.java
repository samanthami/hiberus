package com.hiberus.hiberus.controller;

import com.hiberus.hiberus.model.Department;
import com.hiberus.hiberus.service.DepartmentServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
@RestController
@RequestMapping("/department")
public class DeploymentController {

    private final DepartmentServiceImp departmentService;

    public DeploymentController(DepartmentServiceImp departmentService) {
        this.departmentService = departmentService;
    }


    @PostMapping("/create")
    public ResponseEntity<?> createDepartment(@RequestBody Department department) {
        try {
            departmentService.createDepartment(department);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/delete/{deparmentId}")
    public ResponseEntity<?> disableDepartment(@PathVariable Integer deparmentId) {
        try {
            departmentService.disableDepartment(deparmentId);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all-departments")
    public ResponseEntity<?> allDepartments() {
        try {
            return ResponseEntity.ok(departmentService.getAllDepartments());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
