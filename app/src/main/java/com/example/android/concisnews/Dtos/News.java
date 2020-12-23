package com.example.android.concisnews.Dtos;


public class News {

    int id;
    String title;
    String content;
    String url;
    String urlToImage;

    public News(int id, String title, String content, String url, String urlToImage) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.url = url;
        this.urlToImage = urlToImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
}
