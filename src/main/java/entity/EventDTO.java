/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Oliver
 */
public class EventDTO {
    private int id;
    private String event;
    private String remark;
    private Date date;
    
    //Pet
    private String petName;

    public EventDTO() {
    }

    public EventDTO(String event, Date date, String petName) {
        this.event = event;
        this.date = date;
        this.petName = petName;
    }

    public EventDTO(int id, String event, String remark, Date date) {
        this.id = id;
        this.event = event;
        this.remark = remark;
        this.date = date;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
