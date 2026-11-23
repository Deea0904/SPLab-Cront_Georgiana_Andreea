package com.example.labsp.commands;

import com.example.labsp.books.BookDTO;
import com.example.labsp.books.BooksService;

import java.util.List;

public class GetAllBooksCommand implements Command<List<BookDTO>> {
    private final BooksService service;

    public GetAllBooksCommand(BooksService service) {
        this.service = service;
    }

    @Override
    public List<BookDTO> execute() {
        return service.getAll();
    }
}