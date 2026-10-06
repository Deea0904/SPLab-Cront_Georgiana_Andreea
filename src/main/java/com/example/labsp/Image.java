package com.example.labsp;

public class Image implements Element {
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
