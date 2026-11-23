package com.example.labsp.books;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BooksService {

    private final Map<Integer, BookDTO> books = new ConcurrentHashMap<>();
    private final AtomicInteger nextId = new AtomicInteger(1);

    public List<BookDTO> getAll() {
        return new ArrayList<>(books.values());
    }

    public BookDTO getById(int id) {
        return books.get(id);
    }

    public BookDTO create(BookDTO book) {
        simulateExternalIsbnCall();
        int id = nextId.getAndIncrement();
        BookDTO saved = new BookDTO(id, book.getTitle(), book.getAuthor());
        books.put(id, saved);
        return saved;
    }

    public BookDTO update(int id, BookDTO book) {
        if (!books.containsKey(id)) return null;
        BookDTO updated = new BookDTO(id, book.getTitle(), book.getAuthor());
        books.put(id, updated);
        return updated;
    }

    public boolean delete(int id) {
        return books.remove(id) != null;
    }

    // Simulează serviciul extern de ISBN, fără SLA (de aici POST asincron)
    private void simulateExternalIsbnCall() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}