package com.course.crud.JPA;

import com.course.crud.entity.Employee;

import java.util.List;

public interface EmployeeJPA {
    public Employee retrieve(int Id);
    List<Employee> findAll();
    public List<Employee> findByLastName(String lastName);
    public Employee save(Employee employee);

    public void delete(int Id);

    public void deleteAll();
}
