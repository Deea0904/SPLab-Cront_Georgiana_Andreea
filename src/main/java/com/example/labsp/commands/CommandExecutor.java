package com.example.labsp.commands;

import java.util.concurrent.CompletableFuture;
import com.example.labsp.Book;
import com.example.labsp.persistence.CrudRepository;
public interface CommandExecutor {
    <T> CompletableFuture<T> submit(Command<T> command);
}