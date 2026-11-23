package com.example.labsp.controllers;

import com.example.labsp.Book;
import com.example.labsp.commands.*;
import com.example.labsp.persistence.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/books")
public class BooksController {

    public record BookRequest(String title) {}

    private final CrudRepository<Book, Integer> repo;
    private final SyncCommandExecutor syncExecutor;
    private final AsyncCommandExecutor asyncExecutor;
    private final TaskRegistry tasks;

    public BooksController(CrudRepository<Book, Integer> repo,
                           SyncCommandExecutor syncExecutor,
                           AsyncCommandExecutor asyncExecutor,
                           TaskRegistry tasks) {
        this.repo = repo;
        this.syncExecutor = syncExecutor;
        this.asyncExecutor = asyncExecutor;
        this.tasks = tasks;
    }

    @GetMapping
    public List<Book> getAll() {
        return syncExecutor.submit(new GetAllBooksCommand(repo)).join();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable int id) {
        Book book = syncExecutor.submit(new GetBookByIdCommand(repo, id)).join();
        return book == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody BookRequest req) {
        CompletableFuture<Book> future =
                asyncExecutor.submit(new CreateBookCommand(repo, req.title()));
        String taskId = tasks.register(future);
        return ResponseEntity.accepted()
                .location(URI.create("/tasks/" + taskId))
                .body(Collections.singletonMap("taskId", taskId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable int id, @RequestBody BookRequest req) {
        Book updated = syncExecutor.submit(new UpdateBookCommand(repo, id, req.title())).join();
        return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean deleted = syncExecutor.submit(new DeleteBookCommand(repo, id)).join();
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}