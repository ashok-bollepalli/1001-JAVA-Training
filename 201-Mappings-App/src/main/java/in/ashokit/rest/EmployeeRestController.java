package in.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Employee;
import in.ashokit.service.EmployeeService;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService empService;

	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return empService.saveEmployee(employee);
	}

	@GetMapping("/employee/{empId}")
	public Employee getEmployeeById(@PathVariable Integer empId) {
		return empService.getEmployeeById(empId);
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}
}







