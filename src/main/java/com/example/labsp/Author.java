package com.example.labsp;

public class Author {
    private String name;
   // private String surname;

    public Author(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

//    public String getSurname() {
//        return surname;
//    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setSurname(String surname) {
//        this.surname = surname;
//    }


    public void print() {
        System.out.println("Author: " + name );
    }
}
