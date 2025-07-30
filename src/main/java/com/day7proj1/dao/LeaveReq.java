package com.day7proj1.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.day7proj1.entity.LeaveRequest;
import com.day7proj1.util.dbUtil;

public class LeaveReq {
    dbUtil db=new dbUtil();
    public void addleave(LeaveRequest lr){
        try {
            Connection con=db.getConnection();
            PreparedStatement ps=con.prepareStatement("INSERT INTO leave_request(employee_id,from_date,to_date,reason,status) VALUES(?,?,?,?,?)");
            ps.setInt(1,lr.getemployee_id());
            ps.setDate(2, Date.valueOf(lr.getfrom_date()));
            ps.setDate(3, Date.valueOf(lr.getto_date())); 
            ps.setString(4,lr.getReason());
            ps.setString(5,lr.getStatus());
            ps.executeUpdate();
            System.out.println("Applied Successfully");   
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public List<LeaveRequest> viewbyid(int eid){
        List<LeaveRequest> list=new ArrayList<>();
        try {
            Connection con=db.getConnection();
            PreparedStatement ps=con.prepareStatement("SELECT * FROM leave_request WHERE employee_id=?");
            ps.setInt(1,eid);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            LeaveRequest lrq=new LeaveRequest();
            lrq.setId(rs.getInt("id"));
            lrq.setemployee_id(rs.getInt("employee_id"));
            lrq.setfrom_date(rs.getDate("from_date").toLocalDate());
            lrq.setto_date(rs.getDate("to_date").toLocalDate());
            lrq.setReason(rs.getString("reason"));
            lrq.setStatus(rs.getString("status"));
            list.add(lrq);
            }
            list.sort((b1,b2)->Integer.compare(b1.getId(), b2.getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
       public List<LeaveRequest> viewallreq(){
             List<LeaveRequest> l=new ArrayList<>();
        try {
            Connection con=db.getConnection();
            PreparedStatement ps=con.prepareStatement("SELECT * FROM leave_request");
            ResultSet rs=ps.executeQuery();
             while(rs.next()){
            LeaveRequest lrq=new LeaveRequest();
            lrq.setId(rs.getInt("id"));
            lrq.setemployee_id(rs.getInt("employee_id"));
            lrq.setfrom_date(rs.getDate("from_date").toLocalDate());
            lrq.setto_date(rs.getDate("to_date").toLocalDate());
            lrq.setReason(rs.getString("reason"));
            lrq.setStatus(rs.getString("status"));
            l.add(lrq);
            }
            l.sort((b1,b2)->Integer.compare(b1.getId(), b2.getId()));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       return l;
    }
    public void updatestat(LeaveRequest lr){
        try {
            Connection con=db.getConnection();
            PreparedStatement ps=con.prepareStatement("UPDATE leave_request SET status=? WHERE id=?");
            ps.setString(1,lr.getStatus());
            ps.setInt(2,lr.getId());
            ps.executeUpdate();
            System.out.println("Updated Successfully");   
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
       public void deletereq(int id){
        try {
            Connection con=db.getConnection();
            PreparedStatement ps=con.prepareStatement("DELETE FROM leave_request WHERE id=?");
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("Deleted Successfully");   
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    

    
}
