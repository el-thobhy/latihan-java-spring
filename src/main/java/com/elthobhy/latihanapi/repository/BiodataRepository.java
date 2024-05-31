package com.elthobhy.latihanapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elthobhy.latihanapi.model.Biodata;

@Repository
public interface BiodataRepository extends JpaRepository<Biodata, Long> {
    Optional<List<Biodata>> findByDeleted(boolean deleted);
}
