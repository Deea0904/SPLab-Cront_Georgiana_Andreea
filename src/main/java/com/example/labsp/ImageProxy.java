package com.example.labsp;

import java.awt.*;

public class ImageProxy implements Element, Picture {
    private String url;
    private Dimension dim;
    private Image realImg;

    public ImageProxy(String url) {
        this.url = url;
        this.dim = new Dimension(800, 600);
    }

    private Image loadImage() {
        if (realImg == null) {
            realImg = new Image(url);
        }
        return realImg;
    }

    @Override
    public String url() {
        return url;
    }

    @Override
    public Dimension dim() {
        return dim;
    }

    @Override
    public PictureContent content() {
        return loadImage().content();
    }

    @Override
    public void print() {
        loadImage().print();
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