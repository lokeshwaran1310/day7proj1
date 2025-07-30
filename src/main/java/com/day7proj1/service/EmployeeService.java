package com.day7proj1.service;

import java.util.List;

import com.day7proj1.entity.Employee;
import com.day7proj1.exceptions.EmpNotFound;

public interface EmployeeService {
     public void addEmployee(Employee e);
    public List<Employee> viewallemp()throws EmpNotFound;
    public void viewEmpById(int ei)throws EmpNotFound;
}

