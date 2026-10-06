package com.example.labsp;

public class AlignRight implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, Context context) {
        String format = "%" + context.getLineWidth() + "s%n";
        System.out.printf(format, paragraph.getText());
    }
}