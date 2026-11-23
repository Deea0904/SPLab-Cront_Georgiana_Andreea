package com.example.labsp.commands;

import com.example.labsp.Book;
import com.example.labsp.persistence.CrudRepository;

public class CreateBookCommand implements Command<Book> {
    private final CrudRepository<Book, Integer> repo;
    private final String title;

    public CreateBookCommand(CrudRepository<Book, Integer> repo, String title) {
        this.repo = repo;
        this.title = title;
    }

    @Override
    public Book execute() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Book book = new Book(title);
        return repo.save(book);
    }
}