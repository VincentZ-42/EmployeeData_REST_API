package com.example.employeedata.Employee;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private long id;
    private String name;
    private String email;
    private String phone;
    private String jobTitle;
    private Integer salary;
    private LocalDate dob;
    @Transient
    private Integer age;

    public Employee() {}

    public Employee(long id,
                    String name,
                    String email,
                    String phone,
                    String jobTitle,
                    Integer salary,
                    LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.dob = dob;
    }

    public Employee(String name,
                    String email,
                    String phone,
                    String jobTitle,
                    Integer salary,
                    LocalDate dob) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.dob = dob;
    }

    // Getter Functions
    public long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getJobTitle() { return jobTitle; }
    public Integer getSalary() { return salary; }
    public LocalDate getDob() { return dob; }
    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears(); }

    // Setter Functions
    public void setId(long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }
    public void setSalary(Integer salary) { this.salary = salary; }
    public void setDob(LocalDate dob) { this.dob = dob; }
    public void setAge(Integer age) { this.age = age; }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", salary=" + salary +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
