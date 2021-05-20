package com.example.employeedata.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// This is the API Layer
// - Handles HTTP protocols of GET, POST, PUT, n DELETE
// - Interacts with Service Layer

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public List<Employee> getAllEmployees() { return employeeService.getEmployees(); }

    @GetMapping(path = "{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") Long employeeId) {
            return employeeService.getEmployeeInfo(employeeId);
    }

    @PostMapping
    public void registerNewEmployee(@RequestBody Employee employee) {
        employeeService.addNewEmployee(employee);
    }

    @DeleteMapping(path = "{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

    @PutMapping(path = "{employeeId}")
    public void updateEmployee(
        @PathVariable("employeeId") Long employeeId,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String email,
        @RequestParam(required = false) String phone,
        @RequestParam(required = false) String jobTitle,
        @RequestParam(required = false) Integer salary,
        @RequestParam(required = false) LocalDate dob) {
        employeeService.updateEmployee(employeeId, name, email,
                                        phone, jobTitle, salary, dob);
    }
}
