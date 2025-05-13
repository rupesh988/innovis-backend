package com.atlas.research.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.atlas.research.service.users;

@Repository
public interface userdb extends JpaRepository<users , String> {

    users findByEmailAndPassword(String email, String password);
    users findByEmail(String email);


}
