package com.example.boeingapplication.model;

public class KitItem {
    private int imageResourceId;
    private String text;

    public KitItem(int imageResourceId, String text) {
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