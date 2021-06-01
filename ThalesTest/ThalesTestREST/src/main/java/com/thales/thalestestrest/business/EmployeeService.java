/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thales.thalestestrest.business;

import com.thales.thalestestapi.dto.EmployeeDTO;
import com.thales.thalestestrest.business.components.AnualSalaryCalculator;
import com.thales.thalestestrest.business.components.SalaryContext;
import com.thales.thalestestrest.model.Employee;
import com.thales.thalestestrest.model.service.agents.EmployeeSA;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Business layer to perform operations on data
 * @author Yeison David Sanchez Legarda
 */
@Service
@Slf4j
public class EmployeeService {
    
    @Autowired
    private EmployeeSA employeeSA;
    
    /**
    * Business layer to perform operations on data
    * @param userId user identificator to query
    * @return Employee
    */
    public Employee getEmployeeInformation(Long userId){
        return employeeSA.getEmployeeById(userId);
    }
    
    /**
    * Get all employees information
    * @return Employee List
    */
    public List<Employee> getAllEmployeeInfo(){
        return employeeSA.getAllEmployees();
    }
    
    /**
    * Transform employee to dto
    * @return EmployeeDTO
    */
    public EmployeeDTO toDTO(Employee employee){
      log.info("getting employee {} ",employee);
      SalaryContext salaryContext;
      EmployeeDTO employeeDTO = new EmployeeDTO();
      employeeDTO.setEmployeeAge(employee.getEmployeeAge());
      employeeDTO.setEmployeeName(employee.getEmployeeName());
      employeeDTO.setEmployeeSalary(employee.getEmployeeSalary());
      salaryContext = new SalaryContext(new AnualSalaryCalculator());
      employeeDTO.setEmployeeAnualSalary(salaryContext.calculateSalary(employee));
      return employeeDTO;
    }
    
    /**
    * Transform list of employee to dto
    * @param employees
    * @return EmployeeDTO List
    */
    public List<EmployeeDTO> toDTO(List<Employee> employees){
      return employees.stream().map(emp -> this.toDTO(emp)).collect(Collectors.toList());
    }
}
