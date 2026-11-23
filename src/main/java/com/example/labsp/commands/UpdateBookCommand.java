package com.example.labsp.commands;

import com.example.labsp.Book;
import com.example.labsp.persistence.CrudRepository;

public class UpdateBookCommand implements Command<Book> {
    private final CrudRepository<Book, Integer> repo;
    private final int id;
    private final String title;

    public UpdateBookCommand(CrudRepository<Book, Integer> repo, int id, String title) {
        this.repo = repo;
        this.id = id;
        this.title = title;
    }

    @Override
    public Book execute() {
        Book existing = repo.findById(id).orElse(null);
        if (existing == null) return null;
        existing.setTitle(title);
        return repo.save(existing);
    }
}