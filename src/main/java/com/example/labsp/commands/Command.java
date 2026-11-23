package com.example.labsp.commands;

public interface Command<T> {
    T execute();
}