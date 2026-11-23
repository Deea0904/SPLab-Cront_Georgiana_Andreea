package com.example.labsp.commands;

import com.example.labsp.books.BooksService;

public class DeleteBookCommand implements Command<Boolean> {
    private final BooksService service;
    private final int id;

    public DeleteBookCommand(BooksService service, int id) {
        this.service = service;
        this.id = id;
    }

    @Override
    public Boolean execute() {
        return service.delete(id);
    }
}