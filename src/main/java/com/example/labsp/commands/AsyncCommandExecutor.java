package com.example.labsp.commands;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class AsyncCommandExecutor implements CommandExecutor {

    private final ExecutorService pool = Executors.newFixedThreadPool(4);

    @Override
    public <T> CompletableFuture<T> submit(Command<T> command) {
        return CompletableFuture.supplyAsync(command::execute, pool);
    }

    @PreDestroy
    public void shutdown() {
        pool.shutdown();
    }
}