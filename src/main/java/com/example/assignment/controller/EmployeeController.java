package com.example.assignment.controller;


import com.example.assignment.model.Employee;
import com.example.assignment.service.EmployeeService;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;


    @RequestMapping(value = "/employeeList", method = RequestMethod.GET)
    public String view(){
    List<Employee> employees = employeeService.findEmployee();
    ArrayList<JsonObject> personArray = new ArrayList<JsonObject>();

        for (Employee employee : employees) {
            JsonObject person = new JsonObject();
            person.addProperty("emp_id", employee.getEmpId());
            person.addProperty("emp_name", employee.getEmpName());
            person.addProperty("emp_email", employee.getEmpEmail());
            person.addProperty("emp_photo", employee.getEmpPhoto());
            person.addProperty("branch_name", employee.getBranch().getBranchName());
            person.addProperty("bank_name", employee.getBranch().getBank().getBankName());

            personArray.add(person);
        }
        return personArray.toString();
    }

}
