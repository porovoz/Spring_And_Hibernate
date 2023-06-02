package com.bestapp.spring_and_hibernate.services.Impl;

import com.bestapp.spring_and_hibernate.dao.EmployeeDAO;
import com.bestapp.spring_and_hibernate.model.Employee;
import com.bestapp.spring_and_hibernate.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    @Override
    public Employee create(Employee employee) {
        employeeDAO.create(employee);
        return employee;
    }

    @Override
    public Employee readById(int id) {
        return employeeDAO.readById(id);
    }

    @Override
    public List<Employee> readAll() {
        return employeeDAO.readAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
        return employee;
    }

    @Override
    public Employee deleteEmployee(Employee employee, int id) {
        employeeDAO.deleteEmployee(employee, id);
        return employee;
    }
}
