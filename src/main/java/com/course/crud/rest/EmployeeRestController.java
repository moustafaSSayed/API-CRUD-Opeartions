package com.course.crud.rest;

import com.course.crud.JPA.EmployeeJPA;
import com.course.crud.entity.Employee;
import com.course.crud.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id) {
        if (employeeService.retrieve(id) == null)
            throw new RuntimeException("Employee not Found");
        else
            return employeeService.retrieve(id);
    }

    @GetMapping("/employees/lastName/{lastName}")
    public List<Employee> findByLastName(@PathVariable String lastName) {
        if (employeeService.findByLastName(lastName) == null)
            throw new RuntimeException("Employee not Found");
        else
            return employeeService.findByLastName(lastName);
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        //theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;

    }

    @PutMapping("/employees")
    public Employee editEmployee(@RequestBody Employee theEmployee) {
        //theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;

    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable  int id){
        employeeService.delete(id);
        return "Deleted Sucsessfully";
    }

}
