package com.elthobhy.latihanapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.elthobhy.latihanapi.model.Biodata;
import com.elthobhy.latihanapi.repository.BiodataRepository;

@Service
public class BiodataService {
    @Autowired
    private BiodataRepository bioRepo;

    public Biodata create(Biodata data){
        Optional<Biodata> isExist = bioRepo.findById(data.getId());
        if(isExist.isEmpty()){
            return bioRepo.save(data);
        }else{
            return new Biodata();
        }
    }

    public List<Biodata> read() throws Exception{
        try {
            List<Biodata> data = bioRepo.findByDeleted(false).get();
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
