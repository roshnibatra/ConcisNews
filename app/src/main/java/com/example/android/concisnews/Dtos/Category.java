package com.example.android.concisnews.Dtos;

public class Category {

    String category_link;
    String category_name;

    public Category(String category_link, String category_name) {
        this.category_link = category_link;
        this.category_name = category_name;
    }

    public Category(String category_link) {
        this.category_link = category_link;
    }

    public String getCategory_link() {
        return category_link;
    }

    public void setCategory_link(String category_link) {
        this.category_link = category_link;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
