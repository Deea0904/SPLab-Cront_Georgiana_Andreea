package com.example.labsp;

public interface Visitor {
    void visitBook(Book book);
    void visitSection(Section section);
    void visitParagraph(Paragraph paragraph);
    void visitImage(Image image);
    void visitImageProxy(ImageProxy imageProxy);
    void visitTable(Table table);
}
