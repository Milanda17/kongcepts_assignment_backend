package com.example.assignment.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="Banks")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bank_id", nullable = false)
    private Long bankId;

    @Column(name = "bank_name", nullable = false)
    private String bankName;

    @OneToMany(mappedBy = "bank",cascade = CascadeType.ALL)
    private List<Branch> branch;

    public Bank() {
    }

    public Bank(String bankName, List<Branch> branch) {
        this.bankName = bankName;
        this.branch = branch;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankId=" + bankId +
                ", bankName='" + bankName + '\'' +
//                ", branch=" + branch +
                '}';
    }
}
