package com.pratikesh.prod_ready_features.prodReadyFeatures.clients;

import com.pratikesh.prod_ready_features.prodReadyFeatures.DTO.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {

    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(Long employeeId);

    EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO);
}
