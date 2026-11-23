package com.example.labsp.observer;

import com.example.labsp.Book;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public class SseObserver implements Observer<Book> {

    private final SseEmitter emitter;

    public SseObserver(SseEmitter emitter) {
        this.emitter = emitter;
    }

    @Override
    public void update(Book book) {
        try {
            emitter.send(book, MediaType.APPLICATION_JSON);
        } catch (Exception e) {
            // clientul s-a deconectat; închidem emitter-ul
            emitter.completeWithError(e);
        }
    }
}