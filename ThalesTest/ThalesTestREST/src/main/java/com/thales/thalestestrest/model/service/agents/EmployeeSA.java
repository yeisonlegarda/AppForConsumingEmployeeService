/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thales.thalestestrest.model.service.agents;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thales.thalestestrest.exceptionhandling.MangedException;
import com.thales.thalestestrest.model.Employee;
import com.thales.thalestestrest.utils.JsonDecoderMultiple;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;


/**
 * Service layer to comunicate with exposed services.
 * @author Yeison David Sanchez Legarda
 */
@Component
@Slf4j
public class EmployeeSA {
    @Value("${config.service.employeesUrl:'NA'}")
    private String employeesUrl;
    
    @Autowired
    private RestTemplateBuilder builder;
    
    @Autowired 
    private JsonDecoderMultiple jsonDecoderMultiple;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    
    /**
    * Service to get all employees
    * @return Employee List
    */
    public List<Employee> getAllEmployees() {
        String url = employeesUrl + "employees";
        List<Employee> employees = new ArrayList();
        try{
            JsonNode response = this.getJsonResponse(url);
            List<Object> decodedData = jsonDecoderMultiple.decodeMultipleValues("data", response);
            List<Object> employeeDecodes = jsonDecoderMultiple.deserializeList(decodedData, Employee.class);
            employees = new ArrayList(employeeDecodes);
        }catch(HttpClientErrorException clE){
            throw new MangedException("Error when consuming employee service");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return employees;
                
    }
    
    /**
    * Service to consume services by id an employee
    * @author Yeison David Sanchez Legarda
    */
    public Employee getEmployeeById(Long employeeId) {
        String url = employeesUrl + "employee/"+employeeId;
        try{
            JsonNode response = this.getJsonResponse(url);
            JsonNode decodedData = jsonDecoderMultiple.getNodeByName("data", response);
            return (Employee) jsonDecoderMultiple.nodeToObject(decodedData, Employee.class);
        }catch(HttpClientErrorException clE){
            throw new MangedException("Error when consuming employee service");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    private JsonNode getJsonResponse(String url) {
        JsonNode jsonResponse = null;
        try{
            ParameterizedTypeReference<String> responseType = new ParameterizedTypeReference<String>() {};
            ResponseEntity<String> response = builder.build().exchange(url, HttpMethod.GET, null, responseType);
            jsonResponse = new ObjectMapper().readTree(response.getBody());
        }catch(HttpClientErrorException clE){
            throw new MangedException("Error when consuming employee service");
        }catch(JsonProcessingException jpE){
            throw new MangedException("Processing Json Error");
        }
        
        return jsonResponse;
    }

}
