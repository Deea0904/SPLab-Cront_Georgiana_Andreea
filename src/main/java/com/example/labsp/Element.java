package com.example.labsp;

//poate fi interfata
public interface Element {
     void print();

     void add(Element element) ;
     void remove(Element element) ;

    Element get(int index) ;
}
