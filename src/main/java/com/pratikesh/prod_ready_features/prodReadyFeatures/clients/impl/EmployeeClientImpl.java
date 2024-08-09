package com.pratikesh.prod_ready_features.prodReadyFeatures.clients.impl;

import com.pratikesh.prod_ready_features.prodReadyFeatures.DTO.EmployeeDTO;
import com.pratikesh.prod_ready_features.prodReadyFeatures.advice.ApiResponse;
import com.pratikesh.prod_ready_features.prodReadyFeatures.clients.EmployeeClient;
import com.pratikesh.prod_ready_features.prodReadyFeatures.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;
    @Override
    public List<EmployeeDTO> getAllEmployees() {
        try{
            ApiResponse<List<EmployeeDTO>> employeeDTOList = restClient.get()
                    .uri("emp")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });

            return employeeDTOList.getData();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        try{

            ApiResponse<EmployeeDTO> employeeResponse = restClient.get()
                    .uri("emp/{employeeId}", employeeId)
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return employeeResponse.getData();
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        try{

            ResponseEntity<ApiResponse<EmployeeDTO>> newEmpResponse = restClient.post()
                    .uri("emp")
                    .body(employeeDTO)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) ->{
                        throw new ResourceNotFoundException("Could not create employee");
                    })
                    .toEntity(new ParameterizedTypeReference<>() {
                    });

            return newEmpResponse.getBody().getData();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
