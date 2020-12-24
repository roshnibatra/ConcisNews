package com.example.android.concisnews.Dtos;


public class News {

    int id;
    String slug;
    Rendered excerpt;
    String link;
    Rendered title;
    Category Categories;
    Image better_featured_image;

    public News(int id, String slug, Rendered content, String link, Rendered title, Category categories, Image better_featured_image) {
        this.id = id;
        this.slug = slug;
        this.excerpt = content;
        this.link = link;
        this.title = title;
        Categories = categories;
        this.better_featured_image = better_featured_image;
    }

    public Rendered getTitle() {
        return title;
    }

    public void setTitle(Rendered title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Rendered getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(Rendered content) {
        this.excerpt = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Category getCategories() {
        return Categories;
    }

    public void setCategories(Category categories) {
        Categories = categories;
    }

    public Image getBetter_featured_image() {
        return better_featured_image;
    }

    public void setBetter_featured_image(Image better_featured_image) {
        this.better_featured_image = better_featured_image;
    }
}
