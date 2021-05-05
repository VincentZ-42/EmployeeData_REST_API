package com.example.employeedata.Employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EmployeeConfig {

    // Inputs preset data into our database when our application
    // starts running on the server
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository) {
        return args -> {
            Employee mike = new Employee(
                    "Mike",
                    "mikezhao@gmail.com",
                    "2154567896",
                    "President",
                    70_000,
                    LocalDate.of(1960, Month.JANUARY, 5)
            );

            Employee meizhen = new Employee(
                    "MeiZhen",
                    "meizhen@gmail.com",
                    "2154567899",
                    "Secretary",
                    60_000,
                    LocalDate.of(1970, Month.FEBRUARY, 20)
            );

            Employee sao = new Employee(
                    "Sao",
                    "sao@gmail.com",
                    "2154789632",
                    "Vice President",
                    65_000,
                    LocalDate.of(1972, Month.MARCH, 14)
            );

            Employee vincent = new Employee(
                    "Vincent",
                    "vincent@gmail.com",
                    "2159637854",
                    "Manager",
                    50_000,
                    LocalDate.of(1990, Month.APRIL, 12)
            );

            repository.saveAll( List.of(mike, meizhen, sao, vincent) );
        };
    }
}
