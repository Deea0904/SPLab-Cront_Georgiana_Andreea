package com.example.labsp;

public class Paragraph extends Element{
    private String text;
    private AlignStrategy textAlignment;

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

}
