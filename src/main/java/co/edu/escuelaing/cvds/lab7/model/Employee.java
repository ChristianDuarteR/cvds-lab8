package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

@Builder
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    // Getters
    @Getter
    @Id
    @Column(name = "EMPLOYEE_ID")
    public Long employeeId;

    @Getter
    @Column(name = "FIRST_NAME")
    public String firstName;

    @Getter
    @Column(name = "LAST_NAME")
    public String lastName;

    @Getter
    @Column(name = "ROLE")
    public String role;

    @Getter
    @Column(name = "SALARY")
    public Double salary;

    @Getter
    @Column(name = "COMPANY")
    public String company;

    @Getter
    @Column(name = "BIOLOGICSEX")
    public String byologicSex;

    public Employee() {
    }

    public Employee (Long employeeId) {
        this.employeeId = employeeId;
    }

     public Employee(Long employeeId, String firtsName, String lastName, String role, double salary, String company, String byologicSex) {
        this.employeeId = employeeId;
        this.firstName = firtsName;
        this.lastName = lastName;
        this.role = role;
        this.salary = salary;
        this.company = company;
        this.byologicSex = byologicSex;
    }
    public Employee( String firtsName, String lastName, String role, double salary, String company, String byologicSex) {
        this.firstName = firtsName;
        this.lastName = lastName;
        this.role = role;
        this.salary = salary;
        this.company = company;
        this.byologicSex = byologicSex;
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

    public void setCompany(String company) {
        this.company = company;
    }

    public void setByologicSex(String byologicSex) {
        this.byologicSex = byologicSex;
    }

    // equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Double.compare(salary, employee.salary) == 0 && Objects.equals(employeeId, employee.employeeId) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(role, employee.role) && Objects.equals(company, employee.company) && Objects.equals(byologicSex, employee.byologicSex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, role, salary, company, byologicSex);
    }
}
