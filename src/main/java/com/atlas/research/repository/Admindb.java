package com.atlas.research.repository;


import com.atlas.research.service.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.atlas.research.service.users;

@Repository
public interface Admindb extends JpaRepository<Admin, String> {

    users findByEmailAndPassword(String email, String password);
    users findByEmail(String email);


}
