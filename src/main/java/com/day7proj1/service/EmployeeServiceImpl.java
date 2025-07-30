package com.day7proj1.service;
import java.util.List;

import com.day7proj1.dao.EmployeeDao;
import com.day7proj1.entity.Employee;
import com.day7proj1.exceptions.EmpNotFound;
public class EmployeeServiceImpl implements EmployeeService{
    EmployeeDao ed;
    public EmployeeServiceImpl(EmployeeDao ed){
        this.ed=ed;
    }
    public void addEmployee(Employee e){
         ed.addEmp(e);
    }
    public List<Employee> viewallemp()throws EmpNotFound{
        List<Employee> l=ed.viewemp();
        if(l.isEmpty()){
            try{
            throw new EmpNotFound("Employee not found");
            }
            catch(EmpNotFound e){
               System.out.println( e.getMessage());
            }
        }
        return l;

    }
    public void viewEmpById(int ei)throws EmpNotFound{
         List<Employee> l=ed.viewemp();
         boolean exist=false;
         for(Employee emp:l){
             if(emp.getId()==ei){
                exist=true;
                break;
             }
         }
         if(!exist){
             try{
            throw new EmpNotFound("Employee not found");
            }
            catch(EmpNotFound e){
                System.out.println( e.getMessage());
            }
         }
         ed.empByID(ei);
    }
}
