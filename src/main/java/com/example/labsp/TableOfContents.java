package com.example.labsp;

import java.util.ArrayList;
import java.util.List;

public class TableOfContents implements Visitor {
    private int currentPage = 0;
    private final List<String> entries = new ArrayList<>();

    // fiecare element primește o pagină nouă; doar unele apar în cuprins
    private void register(String label, boolean inToc) {
        currentPage++;
        if (inToc) {
            entries.add(label + " ...... " + currentPage);
        }
    }

    @Override public void visitBook(Book book)           { register("Carte: " + book.getTitle(), true); }
    @Override public void visitSection(Section section)  { register(section.getTitle(), true); }
    @Override public void visitParagraph(Paragraph p)    { register("", false); }
    @Override public void visitImage(Image image)        { register("Imagine: " + image.url(), true); }
    @Override public void visitImageProxy(ImageProxy p)  { register("Imagine: " + p.url(), true); }
    @Override public void visitTable(Table table)        { register("Tabel: " + table.getData(), true); }

    public void printTableOfContents() {
        System.out.println("=== Cuprins ===");
        entries.forEach(System.out::println);
        System.out.println("Total pagini: " + currentPage);
    }
}