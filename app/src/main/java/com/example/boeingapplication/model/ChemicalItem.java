package com.example.boeingapplication.model;

public class ChemicalItem {
    private final int imageResourceId;
    private final String text;


    public ChemicalItem(int imageResourceId, String text) {
        this.imageResourceId = imageResourceId;
        this.text = text;
    }


    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getText() {
        return text;
    }
}


