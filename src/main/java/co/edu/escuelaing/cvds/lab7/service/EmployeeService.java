package co.edu.escuelaing.cvds.lab7.service;

import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getUserById(Long userId) {
        return employeeRepository.findById(userId).orElse(null);
    }

    public List<Employee> getAllUsers() {
        return employeeRepository.findAll();
    }

    public void createUser(Employee user) {
        employeeRepository.save(user);
    }

    public void updateUser(Employee user) {
        employeeRepository.save(user);
    }

    public void deleteUser(Long userId) {
        employeeRepository.deleteById(Long.valueOf(userId));
    }

    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.getReferenceById(Long.valueOf(employeeId));
    }
}