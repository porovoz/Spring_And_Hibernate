package com.bestapp.spring_and_hibernate.dao;

import com.bestapp.spring_and_hibernate.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee create(Employee employee);
    Employee readById(int id);
    List<Employee> readAll();
    Employee updateEmployee(Employee employee);
    Employee deleteEmployee(Employee employee, int id);
}