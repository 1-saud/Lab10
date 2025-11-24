package com.example.lab10.repository;

import com.example.lab10.model.JopApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<JopApplication, Integer> {

}
