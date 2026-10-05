package com.example.labsp;

public class Image extends Element {
    private String name;
    //private String path;

    public Image(String name) {
        this.name = name;
        //this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getPath() {
//        return path;
//    }

//    public void setPath(String path) {
//        this.path = path;
//    }

    public void print() {
        System.out.println("Image with name: " + name );// + path);
    }
}
