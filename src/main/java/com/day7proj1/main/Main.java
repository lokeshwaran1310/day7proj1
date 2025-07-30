package com.day7proj1.main;

import com.day7proj1.controller.empreqController;
import com.day7proj1.dao.EmployeeDao;
import com.day7proj1.dao.LeaveReq;
import com.day7proj1.exceptions.EmpNotFound;
import com.day7proj1.exceptions.InvalidDate;
import com.day7proj1.exceptions.LeaveReqNotFound;
import com.day7proj1.service.EmployeeService;
import com.day7proj1.service.EmployeeServiceImpl;
import com.day7proj1.service.LeaveService;
import com.day7proj1.service.LeaveServiceImpl;

public class Main {
    public static void main(String[] args) {
    EmployeeDao ed=new EmployeeDao();
    LeaveReq lr=new LeaveReq();
    EmployeeService es=new EmployeeServiceImpl(ed);
    LeaveService ls=new LeaveServiceImpl(lr);
    empreqController erc=new empreqController(es,ls);
    try {
        erc.start();
    } catch (EmpNotFound|InvalidDate|LeaveReqNotFound e) {
        e.getMessage();
    }
    }
}
