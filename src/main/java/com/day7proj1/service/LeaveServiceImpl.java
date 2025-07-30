package com.day7proj1.service;

import java.util.List;

import com.day7proj1.dao.LeaveReq;
import com.day7proj1.entity.LeaveRequest;
import com.day7proj1.exceptions.InvalidDate;
import com.day7proj1.exceptions.LeaveReqNotFound;

public class LeaveServiceImpl implements LeaveService{
    LeaveReq lr;
    public LeaveServiceImpl(LeaveReq lr){
        this.lr=lr;
    }
    public void applyLeave(LeaveRequest l)throws InvalidDate
    {
       if(l.getfrom_date().isAfter(l.getto_date())){
        try{
        throw new InvalidDate("From date cannot be after To date");
        }
        catch(InvalidDate e){
           System.out.println( e.getMessage());
        }
       }
       else{
        lr.addleave(l);
       }
    }
    
    public List<LeaveRequest> viewLeave()
    {
      List<LeaveRequest> l=lr.viewallreq();
      if(l.isEmpty()){
        System.out.println("No Request Found");
      }
     
        return l;
    }

    public void UpdateStatus(LeaveRequest l)throws LeaveReqNotFound
    {   List<LeaveRequest> li=lr.viewallreq();
        boolean exist=false;
        for(LeaveRequest en:li){
            if(en.getId()==l.getId()){
                exist=true;
                break;   
            }
        }
        if(!exist){
            try{
            throw new LeaveReqNotFound("No Request Found");
            }
            catch(LeaveReqNotFound e){
             System.out.println( e.getMessage());
            }
        }
        else{
            lr.updatestat(l);
        }
    }
    public List<LeaveRequest> viewByempid(int eid)throws LeaveReqNotFound
    {
      List<LeaveRequest> li=lr.viewbyid(eid);
       if(li.isEmpty()){
       try{
            throw new LeaveReqNotFound("No Request Found");
            }
            catch(LeaveReqNotFound e){
            System.out.println( e.getMessage());
            }
       }
            return li; 
    }
    public void deleterequest(int id)throws LeaveReqNotFound
    {
         List<LeaveRequest> li=lr.viewallreq();
        if(li.isEmpty()){
           try{
            throw new LeaveReqNotFound("No Request Found");
            }
            catch(LeaveReqNotFound e){
             System.out.println( e.getMessage());
            }
        }
      lr.deletereq(id);
    }

    
}
