package com.example.boeingapplication.model;

public class SettingItem {
    private final int imageView;
    private final String text;
    private final int imageView1;

    public SettingItem(int imageView, String text,int imageView1) {
        this.imageView = imageView;
        this.text = text;
        this.imageView1=imageView1;
    }

    public int getImageView() {

        return imageView;
    }


    public String gettext() {

        return text;
    }

    public int getImageView1() {

        return imageView1;
    }

}

