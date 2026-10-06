package com.example.labsp;


import java.awt.*;

public interface Picture {
    String url();

    Dimension dim();

    PictureContent content();
}