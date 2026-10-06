package com.example.labsp;


public class ImageContent implements PictureContent {
    private final String data;

    public ImageContent(String url) {
        this.data = "pixels of " + url;
    }

    @Override
    public String getData() {
        return data;
    }
}