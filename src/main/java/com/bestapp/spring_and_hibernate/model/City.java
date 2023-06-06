package com.bestapp.spring_and_hibernate.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    //    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
//    @Hidden
//    @JsonIgnore
//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    @Column(name = "city_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    public City() {
    }

    public City(String name) {
        this.name = name;
    }

    public City(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id) && Objects.equals(name, city.name) && Objects.equals(employeeList, city.employeeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, employeeList);
    }

    @Override
    public String toString() {
        return getName();
    }
}
