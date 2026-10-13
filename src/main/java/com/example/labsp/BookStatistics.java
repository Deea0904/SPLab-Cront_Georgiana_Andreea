package com.example.labsp;

 public class BookStatistics implements Visitor {
        private int books, sections, paragraphs, images, imageProxies;

        @Override public void visitBook(Book book)            { books++; }
        @Override public void visitSection(Section section)   { sections++; }
        @Override public void visitParagraph(Paragraph p)      { paragraphs++; }
        @Override public void visitImage(Image image)         { images++; }
        @Override public void visitImageProxy(ImageProxy p)   { imageProxies++; }

        public void printStatistics() {
            System.out.println("=== Statistici carte ===");
            System.out.println("Cărți: " + books);
            System.out.println("Secțiuni: " + sections);
            System.out.println("Paragrafe: " + paragraphs);
            System.out.println("Imagini: " + (images + imageProxies));
        }
    }

