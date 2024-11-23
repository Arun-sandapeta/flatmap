package com.neoteric.flatmap;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private String Code;
    private List<Employee> employees = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void add(Employee employee){
        this.employees.add(employee);
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", Code='" + Code + '\'' +
                ", employees=" + employees +
                '}';
    }
}
