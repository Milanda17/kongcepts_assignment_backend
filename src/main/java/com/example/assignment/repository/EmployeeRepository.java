package com.example.assignment.repository;

import com.example.assignment.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public static final String selectEmployees = "SELECT employee_id, employee_name, employee_email, employee_photo, branch_name, bank_name FROM (SELECT * FROM branches Br JOIN banks B ON Br.fk_bank_id=B.bank_id) X JOIN employees E ON X.branch_id=E.fk_branch_id";

    @Query(value = selectEmployees, nativeQuery = true)
    public List<Object[]> selectEmployees();

}
