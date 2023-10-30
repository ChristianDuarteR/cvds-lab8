import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.repository.EmployeeRepository;
import co.edu.escuelaing.cvds.lab7.service.EmployeeService;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    @Test
    public void GivenAnEmployeeWhenSelectShouldBeOK() {
        EmployeeService employeeService = new EmployeeService(mockEmployeeRepository());
        Employee empleado = employeeService.getUserById(1L);
        assertNotNull(empleado);
        assertEquals(1L, empleado.getEmployeeId());
    }

    @Test
    public void GivenNoEmployeesWhenSelectAnEmployeeShouldBeNull() {
        EmployeeService employeeService = new EmployeeService(mockEmployeeRepository());
        Employee empleado = employeeService.getUserById(999L);
        assertNull(empleado);
    }

    @Test
    public void GivenNoEmployeesWhenCreateAnEmployeeShouldBeOk() {
        Employee nuevoEmpleado = new Employee(1L,"Juan", "Pérez", "Desarrollador", 3000.0);
        EmployeeService employeeService = new EmployeeService(mockEmployeeRepository());

        employeeService.createUser(nuevoEmpleado);

        Employee empleadoCreado = employeeService.getUserById(nuevoEmpleado.getEmployeeId());
        assertNotNull(empleadoCreado);
        assertEquals(nuevoEmpleado.getFirtsName(), empleadoCreado.getFirtsName());
    }

    @Test
    public void GivenAnEmployeeWhenDeletShouldOk() {
        EmployeeService employeeService = new EmployeeService(mockEmployeeRepository());
        employeeService.deleteUser(1L);
        Employee empleadoEliminado = employeeService.getUserById(1L);
        assertNull(empleadoEliminado);
    }

    @Test
    public void GivenAnEmployeeRegisteredWhenDeletAndSelectShouldBeNull(){
        EmployeeService employeeService = new EmployeeService(mockEmployeeRepository());
        employeeService.deleteUser(1L);
        Employee empleadoEliminado = employeeService.getUserById(1L);
        assertNull(empleadoEliminado);
    }

    private EmployeeRepository mockEmployeeRepository() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

        Employee empleadoEsperado = new Employee(1L, "Juan", "Pérez", "Desarrollador", 3000.0);
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(empleadoEsperado));
        when(employeeRepository.findById(999L)).thenReturn(Optional.empty());

        doAnswer(invocation -> {
            Employee employeeToSave = invocation.getArgument(0);
            if (employeeToSave.getEmployeeId() == null) {
                // Simular la generación de un nuevo ID para el empleado
                employeeToSave.setEmployeeId(2L);
            }
            return employeeToSave;
        }).when(employeeRepository).save(any(Employee.class));

        doAnswer(invocation -> {
            Long idToDelete = invocation.getArgument(0);
            if (idToDelete.equals(1L)) {
                // Simular la eliminación del empleado con ID 1
                // Haciendo que la siguiente búsqueda retorne nulo
                when(employeeRepository.findById(1L)).thenReturn(Optional.empty());
            }
            return null;
        }).when(employeeRepository).deleteById(any(Long.class));

        return employeeRepository;
    }

}