/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thales.thalestestapi.dto;

import lombok.Data;

/**
 *
 * @author Yeison David Sanchez Legarda
 */
@Data
public class EmployeeDTO {
    private String employeeName;
    private Double employeeSalary;
    private int employeeAge;
    private Double employeeAnualSalary;
}
