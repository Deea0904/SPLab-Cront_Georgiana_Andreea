package com.example.labsp;
import java.util.ArrayList;
import java.util.List;

public class Section extends Element{
    private String name;
    private final List<Element> elements= new ArrayList<>();


    public Section(String name) {
        this.name = name;
    }

    @Override
    public void add(Element element) {
        elements.add(element);
    }

    @Override
    public void remove(Element element) {
        elements.remove(element);
    }

    @Override
    public Element get(int index) {
        return elements.get(index);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println( name);
        for (Element element : elements) {
            element.print();
        }
    }
}
