package com.example.labsp.controllers;

import com.example.labsp.books.BookDTO;
import com.example.labsp.books.BooksService;
import com.example.labsp.commands.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService service;
    private final SyncCommandExecutor syncExecutor;
    private final AsyncCommandExecutor asyncExecutor;
    private final TaskRegistry tasks;

    public BooksController(BooksService service,
                           SyncCommandExecutor syncExecutor,
                           AsyncCommandExecutor asyncExecutor,
                           TaskRegistry tasks) {
        this.service = service;
        this.syncExecutor = syncExecutor;
        this.asyncExecutor = asyncExecutor;
        this.tasks = tasks;
    }

    @GetMapping
    public List<BookDTO> getAll() {
        return syncExecutor.submit(new GetAllBooksCommand(service)).join();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getById(@PathVariable int id) {
        BookDTO book = syncExecutor.submit(new GetBookByIdCommand(service, id)).join();
        return book == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody BookDTO book) {
        CompletableFuture<BookDTO> future =
                asyncExecutor.submit(new CreateBookCommand(service, book));
        String taskId = tasks.register(future);
        return ResponseEntity.accepted()
                .location(URI.create("/tasks/" + taskId))
                .body(Collections.singletonMap("taskId", taskId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> update(@PathVariable int id, @RequestBody BookDTO book) {
        BookDTO updated = syncExecutor.submit(new UpdateBookCommand(service, id, book)).join();
        return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean deleted = syncExecutor.submit(new DeleteBookCommand(service, id)).join();
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}