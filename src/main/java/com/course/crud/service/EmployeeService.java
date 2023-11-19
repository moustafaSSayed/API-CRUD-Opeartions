package com.course.crud.service;

import com.course.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee save(Employee employee);
    public Employee retrieve(int Id);
    List<Employee> findAll();
    public List<Employee> findByLastName(String lastName);
    public void delete(int Id);

    public void deleteAll();
}
