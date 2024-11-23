package com.neoteric.flatmap;

import java.util.*;
import java.util.stream.Collectors;

public class FlatmapTest {
    public static void main(String[] args) {

        Employee arun = new Employee("Arun",001,24,50000.0);
        Employee sai = new Employee("Sai",002,25,60000.0);

        Employee omansh = new Employee("omansh",003,24,70000.0);
        Employee rudved = new Employee("Rudved",004,25,80000.0);

        Employee yashna = new Employee("Yashna",005,24,90000.0);
        Employee hanshith = new Employee("Hanshith",006,25,50000.0);

        Employee uma = new Employee("Uma",007,24,60000.0);
        Employee rama = new Employee("Rama",8,25,70000.0);

        Employee buddu = new Employee("Buddu",9,24,8000.0);
        Employee kanni = new Employee("Kanni",10,25,70000.0);


        Department development = new Department();
        development.setName("Development");
        development.setCode("DEV001");
        development.add(arun);
        development.add(sai);

        Department testing = new Department();
        testing.setName("testing");
        testing.setCode("TEST002");
        testing.add(omansh);
        testing.add(rudved);

        Department support = new Department();
        support.setName("support");
        support.setCode("SUPPORT003");
        support.add(yashna);
        support.add(hanshith);

        Department accounts = new Department();
        accounts.setName("accounts");
        accounts.setCode("ACC004");
        accounts.add(uma);
        accounts.add(rama);

        Department hr = new Department();
        hr.setName("hr");
        hr.setCode("HR005");
        hr.add(kanni);
        hr.add(buddu);

        Company company = new Company();
        company.setName("Amazon");
        company.add(development);
        company.add(testing);
        company.add(support);
        company.add(accounts);
        company.add(hr);

       List<Employee> employeeList = company.getDepartments()
               .stream()
               .flatMap(department -> department.getEmployees()
                       .stream()).collect(Collectors.toList());

        System.out.println(employeeList);

       Optional<Employee> employeeMaxSalary = company.getDepartments()
               .stream()
               .flatMap(department -> department.getEmployees()
                       .stream()).max(Employee::compareTo);

        System.out.println("Max Salary of company: "+employeeMaxSalary);

        Optional<Employee> empMinSalary = company.getDepartments()
                .stream()
                .flatMap(department -> department.getEmployees()
                        .stream()).min(Employee::compareTo);

        System.out.println("Min salary of company: "+empMinSalary);


        OptionalDouble empAvgSalary = company.getDepartments()
                .stream()
                .flatMap(department -> department.getEmployees()
                        .stream()).mapToDouble(Employee::getSalary).average();
        System.out.println("Average Salary of company:"+empAvgSalary);




        Map<String,Optional<Employee>> departmentMinSalary = company.getDepartments()
                .stream()
                .collect(Collectors.toMap(Department::getName,department -> department.getEmployees()
                        .stream().min(Comparator.comparingDouble(Employee::getSalary))));

        System.out.println("Department Min salary"+departmentMinSalary);


       Map<String,Optional<Employee>> departmentMaxSalary = company.getDepartments()
                .stream()
                .collect(Collectors.toMap(Department::getName,department -> department.getEmployees()
                        .stream()
                        .max(Comparator.comparingDouble(Employee::getSalary))));
        System.out.println("Department Max salary"+departmentMaxSalary);

       Map<String,OptionalDouble> departmentAvgSalary = company.getDepartments()
               .stream()
               .collect(Collectors.toMap(Department::getName,department -> department.getEmployees()
                       .stream().mapToDouble(Employee::getSalary).average()));
        System.out.println("Department Avg salary"+departmentAvgSalary);

    }
}
