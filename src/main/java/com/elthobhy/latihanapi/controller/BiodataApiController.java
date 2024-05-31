package com.elthobhy.latihanapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elthobhy.latihanapi.model.Biodata;
import com.elthobhy.latihanapi.services.BiodataService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/biodata")
public class BiodataApiController {
    @Autowired
    private BiodataService bioSvc;
    
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Biodata data) throws Exception {
        try {
            Biodata exist = bioSvc.create(data);
            if(exist.getId()>0){
                return new ResponseEntity<Biodata>(exist, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<String>("Bioada Already Exist", HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("")
    public ResponseEntity<?> read() {
        try {
            List<Biodata> data = bioSvc.read();
            if(data.size()>0){
                return new ResponseEntity<List<Biodata>>(data, HttpStatus.OK);
            }else{
                return new ResponseEntity<String>("null data", HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

}
