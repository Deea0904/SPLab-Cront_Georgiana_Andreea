package com.example.labsp;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
public class Image extends BaseElement implements Element, Picture {

    private String url;

    @Transient
    private ImageContent content;

    public Image() {}

    public Image(String url) {
        this.url = url;
        this.content = new ImageContent(url);
        System.out.println("Loading image from " + url);
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String url() {
        return url;
    }

    @Override
    public Dimension dim() {
        return new Dimension(800, 600);
    }

    @Override
    public ImageContent content() {
        if (content == null) {
            content = new ImageContent(url);
        }
        return content;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitImage(this);
    }

    @Override
    public void print() {
        System.out.println("Image: " + url);
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