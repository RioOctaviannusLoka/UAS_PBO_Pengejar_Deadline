package com.example.taskmanagement;

import java.sql.Date;

// Hold the data for each row in the table
public class taskData {
    private Integer id_plan;
    private String plan;
    private String description;
    private Date date_created;
    private Date due_date;
    private String type;
    private String status;

    public taskData(int id_plan, String plan, String description, Date date_created, Date due_date, String type, String status) {
        this.id_plan = id_plan;
        this.plan = plan;
        this.description = description;
        this.date_created = date_created;
        this.due_date = due_date;
        this.type = type;
        this.status = status;
    }

    public Integer getId_plan(){
        return id_plan;
    }
    public String getPlan(){
        return plan;
    }
    public String getDescription(){
        return description;
    }
    public Date getDate_created(){
        return date_created;
    }
    public Date getDue_date(){
        return due_date;
    }
    public String getType(){
        return type;
    }
    public String getStatus(){
        return status;
    }
}
