package com.example.android.concisnews.Dtos;

import java.util.List;

public class SourceDto {

    String status;
    int TotalResults;
    List<News> articles;

    public SourceDto(List<News> articles) {
        this.articles = articles;
    }

    public List<News> getArticles() {
        return articles;
    }

    public void setArticles(List<News> articles) {
        this.articles = articles;
    }
}
