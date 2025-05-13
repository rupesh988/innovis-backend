package com.atlas.research.repository;

import com.atlas.research.service.Applicants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface applicantdb extends JpaRepository<Applicants,String> {
    Applicants findByEmail(String email);
}
