package com.example.retrofit2.entity;

public class Articulo {
    private int userId;
    private int id;
    private String title;
    private String body;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "\n userId=" + userId +
                ",\n id=" + id +
                ",\n title='" + title + '\'' +
                ",\n body='" + body + '\'' +
                '}';
    }
}
