/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thales.thalestestrest.business.components;

import com.thales.thalestestrest.model.Employee;

/**
 * Context for strategy when getting salary
 * @author Yeison David Sanchez Legarda
 */
public class SalaryContext {
    private SalaryCalculator salaryCalculator;
    
    public SalaryContext(SalaryCalculator salaryCalculator){
        this.salaryCalculator = salaryCalculator;
    }
    
    public Double calculateSalary(Employee employee){
        return this.salaryCalculator.calculateSalary(employee);
    }
}
