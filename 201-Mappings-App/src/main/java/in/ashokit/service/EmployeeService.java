package in.ashokit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Address;
import in.ashokit.entity.Employee;
import in.ashokit.repo.AddressRepository;
import in.ashokit.repo.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private AddressRepository addrRepo;

	public Employee saveEmployee(Employee emp) {

		List<Address> addrList = emp.getAddr();

		if (!addrList.isEmpty()) {
			for (Address a : addrList) {
				a.setEmp(emp);
			}
		}

		return empRepo.save(emp);
	}
	
	public Employee getEmployeeById(Integer empId) {
        return empRepo.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id : " + empId));
    }
	

    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }
	
}
