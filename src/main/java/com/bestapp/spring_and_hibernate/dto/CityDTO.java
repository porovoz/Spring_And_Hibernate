package com.bestapp.spring_and_hibernate.dto;

import com.bestapp.spring_and_hibernate.model.Employee;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
public class CityDTO {

    private Integer id;

    private String name;

    private List<Employee> employeeList;
}
