package com.example.baitap.model;

public class Song {
    private long id ;
    private String name;
    private String singer;
    private String category;
    private String link;

    public Song() {
    }

    public Song(long id, String name, String singer, String category, String link) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
        this.link = link;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
