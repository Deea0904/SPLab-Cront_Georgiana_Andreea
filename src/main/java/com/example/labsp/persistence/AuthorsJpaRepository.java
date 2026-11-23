package com.example.labsp.persistence;

import com.example.labsp.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsJpaRepository extends JpaRepository<Author, Integer> {
}