package com.atlas.research.repository;


import com.atlas.research.service.Papers;
import com.atlas.research.service.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.atlas.research.service.users;

import java.util.List;

@Repository
public interface Projectdb extends JpaRepository<Projects, String> {

    List<Projects> findByEmail(String email);


}
