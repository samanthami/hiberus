package com.hiberus.hiberus.service;

import com.hiberus.hiberus.exceptions.CustomException;
import com.hiberus.hiberus.model.Employee;
import com.hiberus.hiberus.repository.EmployeeRepository;
import com.hiberus.hiberus.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeDepartmentImpl employeeDepartment;

    @Override
    public void createEmployee(Employee employee, Integer departmentId) {
        if (!StringUtil.validateText(employee.getEmployeeName()))
            throw new CustomException("Error al crear el nuevo empleado: El nombre del empleado es obligatorio");
        if (!StringUtil.validateText(employee.getEmployeeLastName()))
            throw new CustomException("Error al crear el nuevo empleado: El apellido del empleado es obligatorio");

        if (!employeeDepartment.existsDepartmentById(departmentId))
            throw new CustomException("Error al crear el nuevo empleado: Departamento Inválido");
        if (employee.getInitDate() == null) employee.setInitDate(new Date());
        try {
            employee.setDepartmentId(departmentId);
            employeeRepository.save(employee);
        } catch (Exception e) {
            throw new CustomException("Error durante la creación del nuevo empleado", e);
        }
    }

    @Override
    public void dismissEmployee(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new CustomException("Error al actualizar el empleado: El empleado no existe"));
        employee.setStatus('I');
        employee.setEndDate(new Date());
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeMaxSalary() {
        List<Employee> employeeList = employeeRepository.findAllByStatus('A');
        return employeeList.stream()
                .filter(employee -> employee.getSalary() !=null)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow();

    }

    @Override
    public Employee getEmployeeMinAge() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().min(Comparator.comparing(Employee::getAge)).orElseThrow();
    }

    @Override
    public Integer numberOfEmployeeLastMonth() {
        LocalDate monthAgo = LocalDate.now().minusMonths(1);
        Date dateAgo = Date.from(monthAgo.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return employeeRepository.countEmployeeByInitDateBetween(dateAgo, new Date());
    }

    @Override
    public List<Employee> getAllActiveEmployees() {
        return employeeRepository.findAllByStatus('A');
    }

}
