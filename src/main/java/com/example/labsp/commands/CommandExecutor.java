package com.example.labsp.commands;

import java.util.concurrent.CompletableFuture;

public interface CommandExecutor {
    <T> CompletableFuture<T> submit(Command<T> command);
}