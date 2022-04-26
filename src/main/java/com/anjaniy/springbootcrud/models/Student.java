package com.anjaniy.springbootcrud.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String branchName;
    private int currentCGPA;
    private int passoutYear;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public int getCurrentCGPA() {
        return currentCGPA;
    }

    public void setCurrentCGPA(int currentCGPA) {
        this.currentCGPA = currentCGPA;
    }

    public int getPassoutYear() {
        return passoutYear;
    }

    public void setPassoutYear(int passoutYear) {
        this.passoutYear = passoutYear;
    }
}
