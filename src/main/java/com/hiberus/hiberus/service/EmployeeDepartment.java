package com.hiberus.hiberus.service;

import com.hiberus.hiberus.repository.DepartmentRepository;
import com.hiberus.hiberus.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDepartment implements EmployeeDepartmentImpl {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Boolean existsEmployeeByDepartmentId(Integer departmentId) {
        return employeeRepository.existsEmployeeByDepartmentId(departmentId);
    }

    @Override
    public Boolean existsDepartmentById(Integer idDepartment) {
        return departmentRepository.existsDepartmentByDepartmentId(idDepartment);
    }
}
