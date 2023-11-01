package co.edu.escuelaing.cvds.lab7.service;

import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
