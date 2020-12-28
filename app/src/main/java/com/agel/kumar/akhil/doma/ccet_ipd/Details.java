package com.agel.kumar.akhil.doma.ccet_ipd;

/**
 * Created by Dell on 01-03-2018.
 */

public class Details {

    private String name;
    private String  father_name;
    private String  roll_no;
    private String  branch;
    private String  college;
    private String phone;
    private String email;


  /*  public Details(String name, String father_name, String roll_no, String branch, String college) {
        this.name = name;
        this.father_name = father_name;
        this.roll_no = roll_no;
        this.branch = branch;
        this.college = college;
    }

    public String getName() {
        return name;
    }

    public String getFather_name() {
        return father_name;
    }

    public String getRoll_no() {
        return roll_no;
    }

    public String getBranch() {
        return branch;
    }

    public String getCollege() {
        return college;
    }*/


    public Details(String name, String father_name, String roll_no, String branch, String college, String email, String phone) {
        this.name = name;
        this.father_name = father_name;
        this.roll_no = roll_no;
        this.branch = branch;
        this.college = college;
        this.phone = phone;
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public String getFather_name() {
        return father_name;
    }

    public String getRoll_no() {
        return roll_no;
    }

    public String getBranch() {
        return branch;
    }

    public String getCollege() {
        return college;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
