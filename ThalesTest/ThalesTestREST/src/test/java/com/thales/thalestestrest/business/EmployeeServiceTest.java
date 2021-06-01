/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thales.thalestestrest.business;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thales.thalestestapi.dto.EmployeeDTO;
import com.thales.thalestestrest.model.Employee;
import com.thales.thalestestrest.model.service.agents.EmployeeSA;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Yeison David Sanchez Legarda
 */
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    
    @Mock
    private EmployeeSA employeeSA;
    
    
    private ModelMapper modelMapper;
    
    @InjectMocks
    private EmployeeService employeeService;
    
    private ObjectMapper mapper;
    
    
    private List<Employee> employees;
    
    public EmployeeServiceTest() throws JsonProcessingException, IOException {
        modelMapper = new ModelMapper();
        mapper = new ObjectMapper();
        String employeesJson = new String(Files.readAllBytes(Paths.get("src/test/resources/employees.json")));
        employees = mapper.readValue(employeesJson, mapper.getTypeFactory().constructCollectionType(List.class, Employee.class));
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getEmployeeInformation method, of class EmployeeService.
     */
    @Test
    public void testGetEmployeeInformation() {
        Mockito.when(employeeSA.getEmployeeById(anyLong())).thenAnswer(new Answer() {
            @Override
            public Employee answer(InvocationOnMock iom) throws Throwable {
                return employees.stream().filter(t -> t.getId().equals(iom.getArgument(0))).findFirst().get();
            }
        });
        System.out.println("getEmployeeInformation");
        Long userId = 1L;
        Employee result =  employeeService.getEmployeeInformation(userId);
        Employee expResult = employees.get(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllEmployeeInfo method, of class EmployeeService.
     */
    @Test
    public void testGetAllEmployeeInfo() {
        Mockito.when(employeeSA.getAllEmployees()).
        thenReturn(employees);
        List<Employee> result = employeeService.getAllEmployeeInfo();
        System.out.println("getAllEmployeeInfo");
        List<Employee> expResult = employees;
        assertEquals(expResult, result);
    }

    /**
     * Test of toDTO method, of class EmployeeService.
     */
    @Test
    public void testToDTO_Employee() {
        System.out.println("toDTO");
        Employee employee = employees.get(0);
        EmployeeDTO result = employeeService.toDTO(employee);
        assertEquals(result.getEmployeeAnualSalary(), result.getEmployeeSalary()*12);
        assertNotNull(result.getEmployeeName());
    }

    /**
     * Test of toDTO method, of class EmployeeService.
     */
    @Test
    public void testToDTO_List() {
        System.out.println("toDTO");
        List<Employee> employees = this.employees;
        List<EmployeeDTO> result = employeeService.toDTO(employees);
        assertFalse(result.isEmpty());
        assertThat(result,hasItem(hasProperty("employeeName", is("Tiger Nixon"))));
       
    }
    
}
