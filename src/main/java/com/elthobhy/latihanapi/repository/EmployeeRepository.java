package com.elthobhy.latihanapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elthobhy.latihanapi.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{//data type dan primary key
    Optional<List<Employee>> findByDeleted(boolean deleted);
}
