/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thales.thalestestrest.business.components;

import com.thales.thalestestrest.model.Employee;

/**
 * Implementation to calculate salary based on months
 * @author Yeison David Sanchez Legarda
 */
public class AnualSalaryCalculator implements SalaryCalculator {
    private final int monthsNumber = 12;
    
    @Override
    public Double calculateSalary(Employee employee) {
        return employee.getEmployeeSalary() * monthsNumber;   
    }
    
}
