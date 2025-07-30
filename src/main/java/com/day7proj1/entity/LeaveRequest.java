package com.day7proj1.entity;

import java.time.LocalDate;

public class LeaveRequest {
    private int id;
    private int employee_id;
    private LocalDate from_date;
    private LocalDate to_date;
    private String reason;
    private String status;
    public LeaveRequest(){

    }
    public LeaveRequest(int employee_id,LocalDate from_date, LocalDate to_date,String reason) {
        this.employee_id = employee_id;
        this.from_date = from_date;
        this.to_date = to_date;
        this.reason = reason;
        this.status = "Pending";
    }

    public int getId(){
       return id;
    }
    public int getemployee_id() {
        return employee_id;
    }

    public LocalDate getfrom_date() {
        return from_date;
    }

    public LocalDate getto_date() {
        return to_date;
    }

    public String getReason() {
        return reason;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setemployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public void setfrom_date(LocalDate from_date) {
        this.from_date = from_date;
    }

    public void setto_date(LocalDate to_date) {
        this.to_date = to_date;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   


    
}
