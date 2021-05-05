package com.example.employeedata.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// This is Data Access Layer
// - Interacts with Database and sends data back to API Layer

@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

    // Same as SELECT * FROM employee WHERE email =
    // - This checks if email is already taken by another user
    @Query("SELECT s from Employee s WHERE s.email = ?1")
    Optional<Employee> findEmployeeByEmail (String email);
}
