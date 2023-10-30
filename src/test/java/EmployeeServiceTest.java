import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.repository.EmployeeRepository;
import co.edu.escuelaing.cvds.lab7.service.EmployeeService;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    @Test
    public void consultarEmpleadoExistentePorIDExitosamente() {
        // Simular un empleado existente con ID 1
        EmployeeService employeeService = new EmployeeService(mockEmployeeRepository());
        Employee empleado = employeeService.getUserById(1L);
        assertNotNull(empleado);
        assertEquals(1L, empleado.getEmployeeId());
    }

    @Test
    public void consultarEmpleadoInexistentePorIDNoRetornaResultado() {
        // Simular un empleado inexistente con ID 999
        EmployeeService employeeService = new EmployeeService(mockEmployeeRepository());
        Employee empleado = employeeService.getUserById(999L);
        assertNull(empleado);
    }

    @Test
    public void crearEmpleadoExitosamente() {
        // Crear un nuevo empleado
        Employee nuevoEmpleado = new Employee("Juan", "Pérez", "Desarrollador", 3000.0);
        EmployeeService employeeService = new EmployeeService(mockEmployeeRepository());

        // Crear el empleado
        employeeService.createUser(nuevoEmpleado);

        // Verificar si el empleado ha sido creado exitosamente
        Employee empleadoCreado = employeeService.getUserById(nuevoEmpleado.getEmployeeId());
        assertNotNull(empleadoCreado);
        assertEquals(nuevoEmpleado.getFirtsName(), empleadoCreado.getFirtsName());
    }

    @Test
    public void eliminarEmpleadoExitosamente() {
        // Simular la eliminación de un empleado con ID 1
        EmployeeService employeeService = new EmployeeService(mockEmployeeRepository());
        employeeService.deleteUser(1L);
        Employee empleadoEliminado = employeeService.getUserById(1L);
        assertNull(empleadoEliminado);
    }

    @Test
    public void eliminarYConsultarEmpleadoNoRetornaResultado() {
        // Simular la eliminación y posterior consulta de un empleado con ID 1
        EmployeeService employeeService = new EmployeeService(mockEmployeeRepository());
        employeeService.deleteUser(1L);
        Employee empleadoEliminado = employeeService.getUserById(1L);
        assertNull(empleadoEliminado);
    }

    private EmployeeRepository mockEmployeeRepository() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

        Employee empleadoEsperado = new Employee(1L, "Juan", "Pérez", "Desarrollador", 3000.0);
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(empleadoEsperado));

        // Simular comportamiento para createUser (save)
        when(employeeRepository.save(any(Employee.class))).thenReturn(new Employee(/* datos simulados */));

        // Simular comportamiento para deleteUser (deleteById)
        doNothing().when(employeeRepository).deleteById(1L);

        return employeeRepository;
    }

}
