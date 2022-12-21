package com.example.baitap.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Song {
    private long id ;
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9]$")
    private String name;
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9]$")
    private String singer;
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9]+(,+)$")
    private String category;
    private String link;

    public Song() {
    }

    public Song(long id,
                @NotEmpty @Pattern(regexp = "^[A-Za-z0-9]$")String name,
                @NotEmpty @Pattern(regexp = "^[A-Za-z0-9]$")String singer,
                @NotEmpty @Pattern(regexp = "^[A-Za-z0-9]+(,+)$")String category
//                String link
                ) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
//        this.link = link;
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
