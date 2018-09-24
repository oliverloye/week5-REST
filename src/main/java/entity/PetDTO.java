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
public class PetDTO {
    private int id;
    private String name;
    private Date birth;
    private String species;
    private Date death;
    
    //Owner
    private String ownerFirstname;
    private String ownerLastname;
    
    //Event
    private String event;
    //private String date;

    public PetDTO() {
    }

    public PetDTO(int id, String name, Date birth, String species) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.species = species;
    }

    public PetDTO(int id, String name, Date birth, String species, String event) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.species = species;
        this.event = event;
        //this.date = date;
    }
    
    

    public PetDTO(int id, String name, Date birth, String species, Date death, String ownerFirstname, String ownerLastname) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.species = species;
        this.death = death;
        this.ownerFirstname = ownerFirstname;
        this.ownerLastname = ownerLastname;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public String getOwnerFirstname() {
        return ownerFirstname;
    }

    public void setOwnerFirstname(String ownerFirstname) {
        this.ownerFirstname = ownerFirstname;
    }

    public String getOwnerLastname() {
        return ownerLastname;
    }

    public void setOwnerLastname(String ownerLastname) {
        this.ownerLastname = ownerLastname;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Date getDeath() {
        return death;
    }

    public void setDeath(Date death) {
        this.death = death;
    }

    @Override
    public String toString() {
        return "PetDTO{" + ", name=" + name + ", birth=" + birth + ", species=" + species + ", death=" + death + '}';
    }
    
    
    
}
