package com.example.labsp;
import java.util.ArrayList;
import java.util.List;

public class Book implements Element {
    private String title;
    private final List <Element> elements=new ArrayList<>();
    private final List <Author> authors=new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void removeAuthor(Author author) {
        authors.remove(author);
    }

    public Author getAuthor(int index) {
        return authors.get(index);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.authors.clear();
        this.authors.add(author);
    }

    public void print() {
        System.out.println("Book: " + title);
        System.out.println();
        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
        }
        System.out.println();
        for (Element element : elements) {
            element.print();
        }
    }

    public void accept(Visitor visitor) {
        visitor.visitBook(this);
        for (Element e : elements) {
            e.accept(visitor);
        }
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

}
