package com.example.labsp.commands;

import org.springframework.stereotype.Component;
import com.example.labsp.Book;
import com.example.labsp.persistence.CrudRepository;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class TaskRegistry {

    private final Map<String, CompletableFuture<?>> tasks = new ConcurrentHashMap<>();

    public String register(CompletableFuture<?> future) {
        String id = UUID.randomUUID().toString();
        tasks.put(id, future);
        return id;
    }

    public Map<String, Object> status(String id) {
        CompletableFuture<?> f = tasks.get(id);
        if (f == null) return null;

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("taskId", id);
        if (f.isCompletedExceptionally()) {
            result.put("status", "FAILED");
        } else if (f.isDone()) {
            result.put("status", "DONE");
            result.put("result", f.join());
        } else {
            result.put("status", "PENDING");
        }
        return result;
    }
}