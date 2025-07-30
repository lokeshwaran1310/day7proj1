package com.day7proj1.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.day7proj1.dao.LeaveReq;
import com.day7proj1.entity.Employee;
import com.day7proj1.entity.LeaveRequest;
import com.day7proj1.exceptions.EmpNotFound;
import com.day7proj1.exceptions.InvalidDate;
import com.day7proj1.exceptions.LeaveReqNotFound;
import com.day7proj1.service.EmployeeService;
import com.day7proj1.service.LeaveService;

public class empreqController {
    EmployeeService es;
    LeaveService ls;
    Scanner s=new Scanner(System.in);
    public empreqController(EmployeeService es,LeaveService ls){
        this.es=es;
        this.ls=ls;
    }
    public void start() throws EmpNotFound, InvalidDate, LeaveReqNotFound{
    System.out.println("Welcome");
    System.out.println("1.Regards Employee\n2.Regards Leave Request");
    int inp=s.nextInt();
    if(inp==1){
        while(true){
      System.out.println("1.Add Employee");
      System.out.println("2.View Employee By Id");
      System.out.println("3.View All Employee");
      System.out.println("4.Exit");
      System.out.println("ENter Choice");
      int ch=s.nextInt();
      switch(ch){
      case 1:
        s.nextLine();
        System.out.println("Enter Name");
        String name = s.nextLine();
        System.out.println("Enter Department");
        String depart = s.nextLine();
        System.out.println("Enter Email");
        String mail = s.nextLine();
        Employee em = new Employee(name, depart, mail);
        addempcheck(em);
        break;


      case 2:
        System.out.println("Enter id");
        int id=s.nextInt();
        es.viewEmpById(id);
        break;
      case 3:
        System.out.println("Displaying Employee Details");
        List<Employee>l=es.viewallemp();
        for(Employee ent:l){
            System.out.println("Employee ID: "+ent.getId());
            System.out.println("EMployee name: "+ent.getName());
            System.out.println("Employee Department: "+ent.getdepartment());
            System.out.println("Employee Email: "+ent.getEmail());
        }
        
        break;
      case 4:
        System.out.println("exit");
        return;
    
      default:
        System.out.println("Enter correct choice");
        break;

      }
        }

    }
    else if(inp==2){
          while(true){
      System.out.println("1.Apply Leave");
      System.out.println("2.View Leave Request By Employee Id");
      System.out.println("3.View All Leave Requests");
      System.out.println("4.Update Status By Id");
      System.out.println("5Delete Request");
      System.out.println("6.Exit");
      System.out.println("ENter Choice");
      int ch=s.nextInt();
      switch(ch){
      case 1:
        System.out.println("Enter Employee Id");
        int emid = s.nextInt();
        s.nextLine();
        System.out.println("Enter From Date (yyyy-MM-dd)");
        String frdate = s.nextLine();
        LocalDate fdate = LocalDate.parse(frdate);
        System.out.println("Enter To Date (yyyy-MM-dd)");
        String toDateStr = s.nextLine();
        LocalDate tdate = LocalDate.parse(toDateStr);
        System.out.println("Enter Reason");
        String reason = s.nextLine();
        LeaveRequest lre = new LeaveRequest(emid, fdate, tdate, reason);
        leavereqcheck(lre);
        break;

      case 2:
        System.out.println("Enter Employee id");
        int id=s.nextInt();
        List<LeaveRequest> l=ls.viewByempid(id);
        for(LeaveRequest enti:l){
            System.out.println("Employee Id: "+id);
            System.out.println("From Date: "+enti.getfrom_date());
            System.out.println("To Date: "+enti.getto_date());
            System.out.println("Reason: "+enti.getReason());
            System.out.println("Status: "+enti.getStatus());
        }
        break;
      case 3:
        System.out.println("Displaying Request Details");
        List<LeaveRequest>lr=ls.viewLeave();
        for(LeaveRequest ent:lr){
            System.out.println("Employee Id: "+ent.getId());
            System.out.println("From Date: "+ent.getfrom_date());
            System.out.println("To Date: "+ent.getto_date());
            System.out.println("Reason: "+ent.getReason());
            System.out.println("Status: "+ent.getStatus());
        }
        break;
        case 4:
        System.out.println("Enter Id");
        int rid=s.nextInt();
        System.out.println("Enter status");
        String stat=s.next();
        LeaveRequest lreq=new LeaveRequest();
        lreq.setId(rid);
        lreq.setStatus((stat));
        ls.UpdateStatus(lreq);
        break;
      case 5:
        System.out.println("Enter Id");
        int i=s.nextInt();
        ls.deleterequest(i);
        break;
      case 6:
        System.out.println("Exit");
        return;
      default:
        System.out.println("Enter correct choice");
        break;

      }
    }

    }
    
    }
     public void addempcheck(Employee emp){
       if(emp.getName().isEmpty()||emp.getdepartment().isEmpty()||emp.getEmail().isEmpty()){
        System.out.println("All fields Need to be filled");
       }
       else{
        es.addEmployee(emp);
       }
    }
   public void leavereqcheck(LeaveRequest lr) throws InvalidDate{
      if(lr.getReason().isEmpty()){
        System.out.println("Reason need to be filled");
      }
      else{
        ls.applyLeave(lr);
      }
   }
}
