package com.example.labsp;

import jakarta.persistence.Entity;

@Entity
@jakarta.persistence.Table(name = "BookTable")
public class Table extends BaseElement implements Element {

    private String data;

    public Table() {}

    public Table(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public void print() {
        System.out.println("Table: " + data);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTable(this);
    }

    @Override
    public void add(Element element) {
        throw new UnsupportedOperationException("Table nu poate avea copii");
    }

    @Override
    public void remove(Element element) {
        throw new UnsupportedOperationException("Table nu poate avea copii");
    }

    @Override
    public Element get(int index) {
        throw new UnsupportedOperationException("Table nu poate avea copii");
    }
}