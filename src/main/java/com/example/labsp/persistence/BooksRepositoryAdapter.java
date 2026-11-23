package com.example.labsp.persistence;

import com.example.labsp.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BooksRepositoryAdapter implements CrudRepository<Book, Integer> {

    private final BooksJpaRepository jpa;

    public BooksRepositoryAdapter(BooksJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override public Book save(Book b) { return jpa.save(b); }
    @Override public Optional<Book> findById(Integer id) { return jpa.findById(id); }
    @Override public List<Book> findAll() { return jpa.findAll(); }
    @Override public void deleteById(Integer id) { jpa.deleteById(id); }
    @Override public boolean existsById(Integer id) { return jpa.existsById(id); }
}