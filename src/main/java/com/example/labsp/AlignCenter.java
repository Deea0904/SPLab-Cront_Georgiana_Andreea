package com.example.labsp;

public class AlignCenter implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, Context context) {
        String text = paragraph.getText();
        int padding = Math.max(0, (context.getLineWidth() - text.length()) / 2);
        System.out.println(" ".repeat(padding) + text);
    }
}