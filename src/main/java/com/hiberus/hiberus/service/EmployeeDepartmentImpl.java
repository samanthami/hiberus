package com.hiberus.hiberus.service;

public interface EmployeeDepartmentImpl {

    Boolean existsEmployeeByDepartmentId(Integer departmentId);
    Boolean existsDepartmentById(Integer idDepartment);
}
