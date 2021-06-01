/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thales.thalestestapi.facade;

import com.thales.thalestestapi.dto.EmployeeDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Facade to consume employee services
 * @author Yeison David Sanchez Legarda
 */
@Api(tags = {"employee"})
@RequestMapping("/employee")
public interface EmployeeServiceFacade {
    
    /**
    * Get information of all employees by requesting service
    * @return List EmployeeDTO
    */
    @ApiOperation(httpMethod = "GET",
            value = "Get information of all employees by requesting service",
            response = EmployeeDTO.class)
    @GetMapping("/all")
    List<EmployeeDTO> allEmployee();

    /**
    * Get information of single employee given a id
    * @param employeeId
    * @return EmployeeDTO
    */
    @ApiOperation(httpMethod = "GET",
            value = "Get information of single employee given a id",
            response = EmployeeDTO.class)
    @GetMapping("/byId")
    EmployeeDTO getEmployeeById(
            @RequestParam(name = "employeeId", required = true) Long employeeId);

}
