package com.example.assignment.model;

import javax.persistence.*;

@Entity
@Table (name = "Employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id", nullable = false)
    private Long empId;

    @Column(name = "employee_name", nullable = false)
    private String empName;

    @Column(name = "employee_email", nullable = false)
    private String empEmail;

    @Column(name = "employee_photo", nullable = false)
    private String empPhoto;

    @ManyToOne
    @JoinColumn(name="fk_branch_id")
    private Branch branch;

    public Employee() {
    }

    public Employee(String empName, String empEmail, String empPhoto, Branch branch) {
        this.empName = empName;
        this.empEmail = empEmail;
        this.empPhoto = empPhoto;
        this.branch = branch;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpPhoto() {
        return empPhoto;
    }

    public void setEmpPhoto(String empPhoto) {
        this.empPhoto = empPhoto;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empPhoto='" + empPhoto + '\'' +
                ", branch=" + branch +
                '}';
    }
}
