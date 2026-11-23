package com.example.labsp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Section extends BaseElement implements Element {

    private String name;

    @OneToMany(targetEntity = BaseElement.class, cascade = CascadeType.ALL)
    private List<Element> elements = new ArrayList<>();

    public Section() {}

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

    public List<Element> getElements() {
        return elements;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.println(name);
        for (Element element : elements) {
            element.print();
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitSection(this);
        for (Element e : elements) {
            e.accept(visitor);
        }
    }

    public String getTitle() {
        return name;
    }
}