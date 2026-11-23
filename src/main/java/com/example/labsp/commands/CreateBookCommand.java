package com.example.labsp.commands;

import com.example.labsp.books.BookDTO;
import com.example.labsp.books.BooksService;

public class CreateBookCommand implements Command<BookDTO> {
    private final BooksService service;
    private final BookDTO book;

    public CreateBookCommand(BooksService service, BookDTO book) {
        this.service = service;
        this.book = book;
    }

    @Override
    public BookDTO execute() {
        return service.create(book);
    }
}