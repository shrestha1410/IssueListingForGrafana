package com.spring.hibernate.issuelisting.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "masterdata")
public class MasterData {
    @Id
    @Column(name = "employeename")
    private String employeename;


    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }
}
