package com.hiberus.hiberus.repository;

import com.hiberus.hiberus.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, IllegalAccessError> {

    Boolean existsDepartmentByDepartmentId(Integer departmentId);
    Department findByDepartmentId(Integer departmentId);

    List<Department> findDepartmentByStatus(char status);

}
