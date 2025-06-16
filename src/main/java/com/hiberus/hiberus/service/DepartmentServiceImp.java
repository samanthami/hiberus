package com.hiberus.hiberus.service;

import com.hiberus.hiberus.exceptions.CustomException;
import com.hiberus.hiberus.model.Department;
import com.hiberus.hiberus.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeDepartmentImpl employeeDepartment;

    @Override
    public void createDepartment(Department department) {
        if (department.getDepartmentId() != null && departmentRepository.existsDepartmentByDepartmentId(department.getDepartmentId()))
            throw new CustomException("Error al crear el nuevo departamento: El departamento ya existe");
        departmentRepository.save(department);
    }

    @Override
    public void disableDepartment(Integer departmentId) {
        if (departmentId != null && !departmentRepository.existsDepartmentByDepartmentId(departmentId))
            throw new CustomException("Error al actualizar el nuevo departamento: El departamento no existe");

        if (employeeDepartment.existsEmployeeByDepartmentId(departmentId))
            throw new CustomException("Error al actualizar el nuevo departamento: El departamento tiene empleados asignados");
        Department department = departmentRepository.findByDepartmentId(departmentId);
        department.setStatus('I');
        departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departmentList = departmentRepository.findDepartmentByStatus('A');
        if(departmentList.isEmpty()) throw new CustomException("No hay departamentos registrados");
        return departmentList;
    }
}
