package com.example.labsp;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
public class Paragraph extends BaseElement implements Element {

    private String text;

    @Transient
    private AlignStrategy textAlignment;

    public Paragraph() {}

    public Paragraph(String name) {
        this.text = name;
    }

    public String getText() {
        return text;
    }

    public void setName(String name) {
        this.text = name;
    }

    public void setAlignStrategy(AlignStrategy textAlignment) {
        this.textAlignment = textAlignment;
    }

    @Override
    public void print() {
        System.out.print("Paragraph: ");
        if (textAlignment != null) {
            textAlignment.render(this, new Context());
        } else {
            System.out.println(text);
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitParagraph(this);
    }

    @Override
    public void add(Element element) {
    }

    @Override
    public void remove(Element element) {
    }

    @Override
    public Element get(int index) {
        return null;
    }
}