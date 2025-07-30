package com.day7proj1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.day7proj1.entity.Employee;
import com.day7proj1.util.dbUtil;

public class EmployeeDao {
    dbUtil db=new dbUtil();
    public void addEmp(Employee e){
        try {
            Connection con=db.getConnection();
            PreparedStatement ps=con.prepareStatement("INSERT INTO employee(name,department,email) VALUES(?,?,?)");
            ps.setString(1,e.getName());
            ps.setString(2,e.getdepartment());
            ps.setString(3,e.getEmail());
            ps.executeUpdate();
            System.out.println("Employee Added");    
        } 
        catch (Exception en) {
            en.printStackTrace();
        }
    }
        public void empByID(int eid){
        try {
            Connection con=db.getConnection();
            PreparedStatement ps=con.prepareStatement("SELECT * FROM employee WHERE id=?");
            ps.setInt(1,eid);
            ResultSet rs=ps.executeQuery();
            rs.next();
            System.out.println("Name: "+rs.getString("name")+" Department: "+rs.getString("department")+" Email: "+rs.getString("email"));  
        } 
        catch (Exception en) {
            en.printStackTrace();
        }
    }

      public List<Employee> viewemp(){
        List<Employee> l=new ArrayList<>();
        try {
            Connection con=db.getConnection();
            PreparedStatement ps=con.prepareStatement("SELECT * FROM employee");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            Employee em=new Employee();
            em.setId(rs.getInt("id"));
            em.setName(rs.getString("name"));
            em.setdepartment(rs.getString("department"));
            em.setEmail(rs.getString("email"));
            l.add(em);
            }
            l.sort((b1,b2)->Integer.compare(b1.getId(), b2.getId()));
            
        }
        catch (Exception en) {
            en.printStackTrace();
        }
        return l;
    }
    

    
}
