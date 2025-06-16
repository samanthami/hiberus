package com.hiberus.hiberus.controller;

import com.hiberus.hiberus.model.Employee;
import com.hiberus.hiberus.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/highestSalary")
    public ResponseEntity<?> highestSalaryByEmployee() {
        try {
            return ResponseEntity.ok(employeeService.getEmployeeMaxSalary());
        } catch (Exception e) {
            log.error("Error al obtener el salario máximo por empleado", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/lowerAge")
    public ResponseEntity<?> getEmployeeLowerAge() {
        try {
            return ResponseEntity.ok(employeeService.getEmployeeMinAge());
        } catch (Exception e) {
            log.error("Error al obtener los empleado más jovenes", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/countLastMonth")
    public ResponseEntity<?> getEmployeeCountLastMonth() {
        try {
            return ResponseEntity.ok(employeeService.numberOfEmployeeLastMonth());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/create/{departmentId}")
    public ResponseEntity<?> createEmployee(@PathVariable Integer departmentId, @RequestBody Employee employee) {
        try {
            employeeService.createEmployee(employee, departmentId);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/delete/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer employeeId) {
        try {
            employeeService.dismissEmployee(employeeId);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/all-employee")
    public ResponseEntity<?> allEmployee(){
        try {
            return ResponseEntity.ok( employeeService.getAllActiveEmployees());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
