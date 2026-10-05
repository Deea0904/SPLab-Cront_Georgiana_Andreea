package com.example.labsp;

public abstract class Element {
    public abstract void print();

    public void add(Element element) {
        throw new UnsupportedOperationException("Cannot add element to this type");
    }
    public void remove(Element element) {
        throw new UnsupportedOperationException("Cannot remove element from this type");
    }

    public Element get(int index) {
        throw new UnsupportedOperationException("Cannot get element from this type");
    }
}
