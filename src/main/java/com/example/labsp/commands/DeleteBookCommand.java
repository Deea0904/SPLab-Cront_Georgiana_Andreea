package com.example.labsp.commands;

import com.example.labsp.Book;
import com.example.labsp.persistence.CrudRepository;

public class DeleteBookCommand implements Command<Boolean> {
    private final CrudRepository<Book, Integer> repo;
    private final int id;

    public DeleteBookCommand(CrudRepository<Book, Integer> repo, int id) {
        this.repo = repo;
        this.id = id;
    }

    @Override
    public Boolean execute() {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}