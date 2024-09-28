package com.example.introapp;

public class IntroSlide {
        public int imageResId;
        public String title;
        public String description;

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public IntroSlide(int imageResId, String title, String
                description) {
            this.imageResId = imageResId;
            this.title = title;
            this.description = description;
        }
}
