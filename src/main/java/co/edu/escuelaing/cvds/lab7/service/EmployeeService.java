package co.edu.escuelaing.cvds.lab7.service;

import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    public List<Employee> getAllUsers() {
        return employeeRepository.findAll();
    }

    public void createUser(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateUser(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteUser(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @PostConstruct
    public List<Employee> generateRandomEmployees() {
        Random random = new Random();
        int numEmployees = random.nextInt(51) + 50; // Entre 50 y 100 empleados

        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < numEmployees; i++) {
            Employee employee = createRandomEmployee();
            employeeRepository.save(employee);
        }

        return employees;
    }

    private Employee createRandomEmployee() {
        Random random = new Random();
        long employeeId = random.nextInt(1000) + 1;
        String[] firstNames = {"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Henry", "Isabella", "Jack", "Katherine", "Liam", "Mia", "Noah", "Olivia", "Parker", "Quinn", "Ryan", "Sophia", "Thomas", "Uma", "Victor", "Willow", "Xander", "Yara", "Zane"};
        String[] lastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia", "Martinez", "Robinson", "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall"};
        String[] roles = {"Ingeniero", "Gerente", "Analista", "Desarrollador", "Estudiante", "Jefe de Seguridad"};
        double salary = 20000 + random.nextInt(80000);
        String[] companies = {"Google", "Amazon", "SAS", "Oracle", "Caracol", "NVIDIA"};
        String[] sexes = {"Masculino", "Femenino"};

        String firstName = firstNames[random.nextInt(firstNames.length)];
        String lastName = lastNames[random.nextInt(lastNames.length)];
        String role = roles[random.nextInt(roles.length)];
        String company = companies[random.nextInt(companies.length)];
        String sex = sexes[random.nextInt(sexes.length)];

        return new Employee(employeeId, firstName, lastName, role, salary, company, sex);
    }
}
