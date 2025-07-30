package com.day7proj1.entity;

public class Employee {
    private int id;
    private String name;
    private String department;
    private String email;
   public Employee(){

   }
    public Employee(String name,String department,String email) {
        this.name = name;
        this.department = department;
        this.email = email;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getdepartment() {
        return department;
    }
    public String getEmail() {
        return email;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setdepartment(String department) {
        this.department = department;
    }
    public void setEmail(String email) {
        this.email = email;
    }
   
    

    
}
