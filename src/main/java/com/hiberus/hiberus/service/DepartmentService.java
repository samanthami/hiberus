package com.hiberus.hiberus.service;

import com.hiberus.hiberus.model.Department;

import java.util.List;

public interface DepartmentService {

    void createDepartment(Department department);

    void disableDepartment(Integer departmentId);

    List<Department> getAllDepartments();
}
