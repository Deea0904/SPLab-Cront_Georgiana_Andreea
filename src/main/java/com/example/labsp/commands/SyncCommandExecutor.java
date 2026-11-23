package com.example.labsp.commands;

import org.springframework.stereotype.Component;
import com.example.labsp.Book;
import com.example.labsp.persistence.CrudRepository;
import java.util.concurrent.CompletableFuture;

@Component
public class SyncCommandExecutor implements CommandExecutor {

    @Override
    public <T> CompletableFuture<T> submit(Command<T> command) {
        return CompletableFuture.completedFuture(command.execute());
    }
}