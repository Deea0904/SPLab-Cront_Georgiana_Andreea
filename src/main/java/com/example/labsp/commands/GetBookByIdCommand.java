package com.example.labsp.commands;

import com.example.labsp.books.BookDTO;
import com.example.labsp.books.BooksService;

public class GetBookByIdCommand implements Command<BookDTO> {
    private final BooksService service;
    private final int id;

    public GetBookByIdCommand(BooksService service, int id) {
        this.service = service;
        this.id = id;
    }

    @Override
    public BookDTO execute() {
        return service.getById(id);
    }
}