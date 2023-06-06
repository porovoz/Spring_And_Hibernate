package com.bestapp.spring_and_hibernate.services;

import com.bestapp.spring_and_hibernate.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(Employee employee);
    Employee readById(Integer id);
    List<Employee> readAll();
    Employee updateEmployee(Employee employee);
    Employee deleteEmployee(Employee employee, Integer id);
}