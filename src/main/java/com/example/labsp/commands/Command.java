package com.example.labsp.commands;
import com.example.labsp.Book;
import com.example.labsp.persistence.CrudRepository;
public interface Command<T> {
    T execute();
}