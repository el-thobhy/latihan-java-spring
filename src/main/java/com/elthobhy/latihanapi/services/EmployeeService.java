package com.elthobhy.latihanapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.elthobhy.latihanapi.model.Employee;
import com.elthobhy.latihanapi.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository empRepo;

    public Employee create(Employee data) {
        Optional<Employee> isExist = empRepo.findById(data.getId());
        if (isExist.isEmpty()) {
            return empRepo.save(data);
        } else {
            return new Employee();
        }
    }
    public List<Employee> read() throws Exception{
        try {
            List<Employee> data = empRepo.findByDeleted(false).get();
            if(data.size()>0){
                return data;
            }else{
                throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Category has no data");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
