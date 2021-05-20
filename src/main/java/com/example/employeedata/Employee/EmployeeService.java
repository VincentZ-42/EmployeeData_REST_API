package com.example.employeedata.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// This is Service Layer
// - Handles business logic between API Layer and Data Access Layer

@Service
public class EmployeeService {

        private final EmployeeRepository employeeRepository;

        @Autowired
        public EmployeeService(EmployeeRepository employeeRepository) {
                this.employeeRepository = employeeRepository;
        }

        // Retrieves all Employee data from server
        public List<Employee> getEmployees() {
                return employeeRepository.findAll();
        }

        // Retrieves Employee data from server given Employee's id
        public Employee getEmployeeInfo(Long employeeId) {
                boolean exists = employeeRepository.existsById(employeeId);
                if (!exists) {
                        throw new IllegalStateException(
                            "employee with id " + employeeId + " does not exists");
                }
                //GetOne returns a reference to the entity and does not interact with database
                return employeeRepository.findById(employeeId).get();
        }

        // Adds a new Employee into database
        public void addNewEmployee(Employee employee) {
                Optional<Employee> employeeOptional = employeeRepository
                        .findEmployeeByEmail(employee.getEmail());
                if (employeeOptional.isPresent()) {
                        throw new IllegalStateException("email taken");
                }
                employeeRepository.save(employee);
        }

        // Deletes Employee from database, checking if Employee exists first
        public void deleteEmployee(Long employeeId) {
                boolean exists = employeeRepository.existsById(employeeId);
                if (!exists) {
                        throw new IllegalStateException(
                            "employee with id " + employeeId + " does not exists");
                }
                employeeRepository.deleteById(employeeId);
        }

        @Transactional
        public void updateEmployee(Long employeeId, String name, String email,
                                   String phone, String jobTitle, Integer salary,
                                   LocalDate dob) {
                Employee employee = employeeRepository.findById(employeeId)
                    .orElseThrow(() -> new IllegalStateException(
                        "employee with id " + employeeId + " does not exist"));

                if (name != null && name.length() > 0 &&
                !Objects.equals(employee.getName(), name)) {
                        employee.setName(name);
                }

                if (email != null && email.length() > 0 &&
                    !Objects.equals(employee.getEmail(), email)) {
                        Optional<Employee> employeeOptional = employeeRepository
                        .findEmployeeByEmail(email);
                        if (employeeOptional.isPresent()) {
                                throw new IllegalStateException("email taken");
                        }
                        employee.setEmail(email);
                }

                if (phone != null && phone.length() > 0 &&
                    !Objects.equals(employee.getPhone(), phone)) {
                        employee.setPhone(phone);
                }

                if (jobTitle != null && jobTitle.length() > 0 &&
                    !Objects.equals(employee.getJobTitle(), jobTitle)) {
                        employee.setJobTitle(jobTitle);
                }

                if (salary != null && salary > 0 &&
                    !Objects.equals(employee.getSalary(), salary)) {
                        employee.setSalary(salary);
                }

                if (dob != null && name.length() > 0 &&
                    !Objects.equals(employee.getName(), name)) {
                        employee.setName(name);
                }
        }
}
