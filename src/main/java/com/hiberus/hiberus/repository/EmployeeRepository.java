package com.hiberus.hiberus.repository;

import com.hiberus.hiberus.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    Integer countEmployeeByInitDateBetween(Date initDate, Date initDate2);

    boolean existsEmployeeByDepartmentId(Integer departmentId);

    List<Employee> findAllByStatus(char status);

}
