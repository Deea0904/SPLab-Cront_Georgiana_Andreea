package com.example.labsp;

public class Paragraph extends Element{
    private String name;

    public Paragraph(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("Paragrph: " + name);
    }
}
