package co.edu.escuelaing.cvds.lab7.controller;
import co.edu.escuelaing.cvds.lab7.model.Employee;
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

    @GetMapping("/employee/{employeeId}")
    public String viewEmployee(@PathVariable String employeeId, Model model) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        model.addAttribute("employee", employee);
        return "READ";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee updatedEmployee) {
        Employee existingEmployee = employeeService.getUserById(Long.valueOf(id));
        if (existingEmployee == null) {
            return ResponseEntity.notFound().build();
        }

        updatedEmployee.setEmployeeId(id);
        employeeService.updateUser(updatedEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String id) {
        Employee existingEmployee = employeeService.getUserById(Long.valueOf(id));
        if (existingEmployee == null) {
            return ResponseEntity.notFound().build();
        }

        employeeService.deleteUser(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}