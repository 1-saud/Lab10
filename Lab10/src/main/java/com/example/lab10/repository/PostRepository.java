package com.example.lab10.repository;

import com.example.lab10.model.JopPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<JopPost,Integer> {
}
