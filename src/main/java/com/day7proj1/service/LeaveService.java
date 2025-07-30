package com.day7proj1.service;

import java.util.List;
import com.day7proj1.exceptions.LeaveReqNotFound;;
import com.day7proj1.entity.LeaveRequest;
import com.day7proj1.exceptions.InvalidDate;

public interface LeaveService {
    public void applyLeave(LeaveRequest l)throws InvalidDate;
    public List<LeaveRequest> viewLeave();
    public void UpdateStatus(LeaveRequest l)throws LeaveReqNotFound;
    public List<LeaveRequest> viewByempid(int eid)throws LeaveReqNotFound;
    public void deleterequest(int id)throws LeaveReqNotFound;
}
