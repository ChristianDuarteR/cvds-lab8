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
    public String biologicSex;

    public Employee() {
    }

    public Employee (Long employeeId) {
        this.employeeId = employeeId;
    }

     public Employee(Long employeeId, String firstName, String lastName, String role, double salary, String company, String biologicSex) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.salary = salary;
        this.company = company;
        this.biologicSex = biologicSex;
    }
    public Employee(String firstName, String lastName, String role, double salary, String company, String biologicSex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.salary = salary;
        this.company = company;
        this.biologicSex = biologicSex;
    }
    // setters


    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
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

    public void setBiologicSex(String byologicSex) {
        this.biologicSex = byologicSex;
    }

    // equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Double.compare(salary, employee.salary) == 0 && Objects.equals(employeeId, employee.employeeId) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(role, employee.role) && Objects.equals(company, employee.company) && Objects.equals(biologicSex, employee.biologicSex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, role, salary, company, biologicSex);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", first_name='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                ", company='" + company + '\'' +
                ", biologicSex='" + biologicSex + '\'' +
                '}';
    }
}