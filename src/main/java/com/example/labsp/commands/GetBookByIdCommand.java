package com.example.labsp.commands;

import com.example.labsp.Book;
import com.example.labsp.persistence.CrudRepository;

public class GetBookByIdCommand implements Command<Book> {
    private final CrudRepository<Book, Integer> repo;
    private final int id;

    public GetBookByIdCommand(CrudRepository<Book, Integer> repo, int id) {
        this.repo = repo;
        this.id = id;
    }

    @Override
    public Book execute() {
        return repo.findById(id).orElse(null);
    }
}