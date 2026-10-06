package com.example.labsp;

import java.util.concurrent.TimeUnit;

public class Image implements Element, Picture {
    private String url;
    private ImageContent content;

    public Image(String url) {
        this.url = url;
        this.content = new ImageContent(url);
        System.out.println("Loading image from " + url);
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
        return content;
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
