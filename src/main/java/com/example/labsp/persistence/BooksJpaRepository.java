package com.example.labsp.persistence;

import com.example.labsp.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksJpaRepository extends JpaRepository<Book, Integer> {
}