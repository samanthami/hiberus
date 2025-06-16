package com.hiberus.hiberus.service;

import com.hiberus.hiberus.model.Employee;

import java.util.List;

public interface EmployeeService {

    void createEmployee(Employee employee, Integer departmentId);

    void dismissEmployee(Integer employeeId);

    Employee getEmployeeMaxSalary();

    Employee getEmployeeMinAge();

    Integer numberOfEmployeeLastMonth();

    List<Employee> getAllActiveEmployees();

}
