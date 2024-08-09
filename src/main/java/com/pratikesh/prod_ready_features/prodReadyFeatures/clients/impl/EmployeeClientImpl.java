package com.pratikesh.prod_ready_features.prodReadyFeatures.clients.impl;

import com.pratikesh.prod_ready_features.prodReadyFeatures.DTO.EmployeeDTO;
import com.pratikesh.prod_ready_features.prodReadyFeatures.advice.ApiResponse;
import com.pratikesh.prod_ready_features.prodReadyFeatures.clients.EmployeeClient;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
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
                    .uri("employees")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });

            return employeeDTOList.getData();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
