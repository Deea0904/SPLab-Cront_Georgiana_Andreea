package com.example.labsp;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private final List <Element> elements=new ArrayList<>();
    private final List <Author> authors=new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addContent(Element element) {
        elements.add(element);
    }

    public void removeContent(Element element) {
        elements.remove(element);
    }

    public Element getElement(int index) {
        return elements.get(index);
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
}
