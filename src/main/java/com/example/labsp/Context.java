package com.example.labsp;


public class Context {
        private final int lineWidth;

        public Context() {
            this(40);
        }

        public Context(int lineWidth) {
            this.lineWidth = lineWidth;
        }

        public int getLineWidth() {
            return lineWidth;
        }
    }


