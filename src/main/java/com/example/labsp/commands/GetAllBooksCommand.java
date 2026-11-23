package com.example.labsp.commands;

import com.example.labsp.Book;
import com.example.labsp.persistence.CrudRepository;

import java.util.List;

public class GetAllBooksCommand implements Command<List<Book>> {
    private final CrudRepository<Book, Integer> repo;

    public GetAllBooksCommand(CrudRepository<Book, Integer> repo) {
        this.repo = repo;
    }

    @Override
    public List<Book> execute() {
        return repo.findAll();
    }
}