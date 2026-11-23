package com.example.labsp.commands;

import com.example.labsp.books.BookDTO;
import com.example.labsp.books.BooksService;

public class UpdateBookCommand implements Command<BookDTO> {
    private final BooksService service;
    private final int id;
    private final BookDTO book;

    public UpdateBookCommand(BooksService service, int id, BookDTO book) {
        this.service = service;
        this.id = id;
        this.book = book;
    }

    @Override
    public BookDTO execute() {
        return service.update(id, book);
    }
}