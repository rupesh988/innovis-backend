package com.atlas.research.repository;


import com.atlas.research.service.Papers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.atlas.research.service.users;

import java.util.List;

@Repository
public interface Paperdb extends JpaRepository<Papers, String> {

    List<Papers> findByEmail(String email);


}
