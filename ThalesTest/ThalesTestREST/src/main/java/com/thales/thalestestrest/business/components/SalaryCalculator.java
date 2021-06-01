/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thales.thalestestrest.business.components;

import com.thales.thalestestrest.model.Employee;

/**
 * Interface to calculate salary
 * @author Yeison David Sanchez Legarda
 */
public interface SalaryCalculator {
    /**
    * Calulate salary operation
    * @param employee
    * @return double
    */
    Double calculateSalary(Employee employee);
}
