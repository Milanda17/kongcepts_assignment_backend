package com.example.assignment.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "Branches")
public class Branch
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "branch_id", nullable = false)
    private Long branchId;

    @Column(name = "branch_name", nullable = false)
    private String branchName;

    @OneToMany(mappedBy = "branch",cascade = CascadeType.ALL)
    private List<Employee> employee;

    @ManyToOne
    @JoinColumn(name="fk_bank_id")
    private Bank bank;

    public Branch() {
    }

    public Branch(String branchName, List<Employee> employee, Bank bank) {
        this.branchName = branchName;
        this.employee = employee;
        this.bank = bank;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchId=" + branchId +
                ", branchName='" + branchName + '\'' +
                ", bank=" + bank +
                '}';
    }
}
