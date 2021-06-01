/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thales.thalestestrest.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

/**
 * Employee information to get from service layer
 * @author Yeison David Sanchez Legarda
 */
@Data
public class Employee {
    
    private Long id;
    
    @JsonAlias("employee_name")
    private String employeeName;
    
    @JsonAlias("employee_salary")
    private Double employeeSalary;
    
    @JsonAlias("employee_age")
    private Integer employeeAge;
    
    @JsonAlias("profile_image")
    private String profileImage;
    
    
    
}
