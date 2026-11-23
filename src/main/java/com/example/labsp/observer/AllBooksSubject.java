package com.example.labsp.observer;

import com.example.labsp.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class AllBooksSubject implements Subject<Book> {

    private final List<Observer<Book>> observers = new CopyOnWriteArrayList<>();
    private volatile Book lastBook;

    @Override
    public void attach(Observer<Book> observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer<Book> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Book book) {
        for (Observer<Book> observer : observers) {
            observer.update(book);
        }
    }

    // Schimbă starea subiectului și anunță observatorii
    public void add(Book book) {
        this.lastBook = book;
        notifyObservers(book);
    }

    public Book getLastBook() {
        return lastBook;
    }
}