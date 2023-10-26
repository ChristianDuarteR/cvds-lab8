package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.Objects;

@Builder
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @Column(name = "EMPLOYEE_ID")
    public Long employeeId;

    @Column(name = "FIRST_NAME")
    public String firstName;

    @Column(name = "LAST_NAME")
    public String lastName;

    @Column(name = "ROLE")
    public String role;

    @Column(name = "SALARY")
    public Double salary;

    public Employee() {
    }

    public Employee (Long employeeId) {
        this.employeeId = employeeId;
    }

     public Employee(Long employeeId, String firtsName, String lastName, String role, double salary) {
        this.employeeId = employeeId;
        this.firstName = firtsName;
        this.lastName = lastName;
        this.role = role;
        this.salary = salary;
    }
    public Employee( String firtsName, String lastName, String role, double salary) {
        this.firstName = firtsName;
        this.lastName = lastName;
        this.role = role;
        this.salary = salary;
    }

   
    // Getters
    public Long getEmployeeId() {
        return employeeId;
    }

    public String getFirtsName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }

    public double getSalary() {
        return salary;
    }

    // setters


    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirtsName(String firtsName) {
        this.firstName = firtsName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    // equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Double.compare(salary, employee.salary) == 0 && Objects.equals(employeeId, employee.employeeId) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, role, salary);
    }
}
