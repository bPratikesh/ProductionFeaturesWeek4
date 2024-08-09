package com.pratikesh.prod_ready_features.prodReadyFeatures;

import com.pratikesh.prod_ready_features.prodReadyFeatures.DTO.EmployeeDTO;
import com.pratikesh.prod_ready_features.prodReadyFeatures.clients.EmployeeClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class ProdReadyFeaturesApplicationTests {

	@Autowired
	private EmployeeClient employeeClient;

	@Test
	void getAllEmployees(){
		List<EmployeeDTO> employeeDTOList = employeeClient.getAllEmployees();
		System.out.println(employeeDTOList);
	}

	@Test
	void getEmpById(){
		EmployeeDTO employeeDTO = employeeClient.getEmployeeById(1L);
		System.out.println(employeeDTO);
	}

	@Test
	void createNewEmp(){
		EmployeeDTO employeeDTO = new EmployeeDTO(null, "Pratikesh", "pratikeshb9@gmail.com",
				2, LocalDate.of(2020,12,5),true);

		EmployeeDTO savedEmployeeDTO = employeeClient.createNewEmployee(employeeDTO);
		System.out.println(savedEmployeeDTO);
	}

}
