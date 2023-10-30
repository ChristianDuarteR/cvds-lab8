package co.edu.escuelaing.cvds.lab7.controller;
import  co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllUsers();
        model.addAttribute("employees", employees);
        return "READ";
    }

    @GetMapping("/create")
    public String createEmptyEmployee(Model model) {
        model.addAttribute("employee",new Employee());
        return "CREATE";
    }

    @PostMapping("/employees/create")
    public String createEmployee(@ModelAttribute Employee employee) {
        employeeService.createUser(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/{employeeId}")
    public String viewEmployee(@PathVariable Long employeeId, Model model) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        model.addAttribute("employee", employee);
        return "READ";
    }

    @GetMapping("/update/{employeeId}")
    public String loadUpdateEmployeeForm(@PathVariable Long employeeId, Model model) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        model.addAttribute("employee", employee);
        return "UPDATE";
    }

    @PostMapping("/update/{employeeId}")
    public String updateEmployee(@PathVariable Long employeeId, @ModelAttribute Employee updatedEmployee) {
        Employee existingEmployee = employeeService.getEmployeeById(employeeId);
        if (existingEmployee == null) {
            return "redirect:/employees";
        }

        updatedEmployee.setEmployeeId(employeeId);
        employeeService.updateUser(updatedEmployee);
        return "redirect:/employees";
    }

    @PostMapping("/delete/{employeeId}")
    public String deleteEmployee(@PathVariable long employeeId) {
        employeeService.deleteUser(employeeId);
        return "redirect:/employees";
    }
}