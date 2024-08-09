package com.pratikesh.prod_ready_features.prodReadyFeatures;

import com.pratikesh.prod_ready_features.prodReadyFeatures.DTO.EmployeeDTO;
import com.pratikesh.prod_ready_features.prodReadyFeatures.clients.EmployeeClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProdReadyFeaturesApplicationTests {

	@Autowired
	private EmployeeClient employeeClient;

	@Test
	void getAllEMployees(){
		List<EmployeeDTO> employeeDTOList = employeeClient.getAllEmployees();
		System.out.println(employeeDTOList);
	}

}
