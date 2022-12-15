package com.example.baitap.model;

public class Mail {
    private String language;
    private double size;
    private boolean filter;
    private String signature;

    public Mail() {
    }

    public Mail(String language, double size, boolean filter, String signature) {
        this.language = language;
        this.size = size;
        this.filter = filter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public boolean getFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
