/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thales.thalestestrest.controller;

import com.thales.thalestestapi.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.RestController;
import com.thales.thalestestapi.facade.EmployeeServiceFacade;
import com.thales.thalestestrest.business.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Controller implementation
 * @author Yeison David Sanchez Legarda
 */
@RestController
public class EmployeeController implements EmployeeServiceFacade {
    @Autowired
    private EmployeeService employeeService;
    
    @Override
    public List<EmployeeDTO> allEmployee() {
        return employeeService.toDTO(employeeService.getAllEmployeeInfo());
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        return employeeService.toDTO(employeeService.getEmployeeInformation(employeeId));
    }
    
}
