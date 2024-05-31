package com.elthobhy.latihanapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elthobhy.latihanapi.model.Employee;
import com.elthobhy.latihanapi.services.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/employee")
public class EmployeApiController {
    @Autowired
    private EmployeeService empSvc;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Employee data) throws Exception {
        try {
            Employee exist = empSvc.create(data);
            if(exist.getId()>0){
                return new ResponseEntity<Employee>(exist, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<String>("Employee Already Exist", HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("")
    public ResponseEntity<?> read() {
        try {
            List<Employee> data = empSvc.read();
            if(data.size()>0){
                return new ResponseEntity<List<Employee>>(data, HttpStatus.OK);
            }else{
                return new ResponseEntity<String>("null data", HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
