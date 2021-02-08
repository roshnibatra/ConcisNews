package com.example.android.concisnews.Dtos;

public class MainFilter {

    String header;
    String sub_header;

    public MainFilter(String header, String sub_header) {
        this.header = header;
        this.sub_header = sub_header;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSub_header() {
        return sub_header;
    }

    public void setSub_header(String sub_header) {
        this.sub_header = sub_header;
    }
}
