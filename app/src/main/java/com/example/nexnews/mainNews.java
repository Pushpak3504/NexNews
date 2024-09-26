package com.example.nexnews;

import java.util.ArrayList;

public class mainNews {

    private String status;
    private String totalresults;
    private ArrayList<ModelClass> articles;

    public mainNews(String status, String totalresults, ArrayList<ModelClass> articles) {
        this.status = status;
        this.totalresults = totalresults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalresults() {
        return totalresults;
    }

    public void setTotalresults(String totalresults) {
        this.totalresults = totalresults;
    }

    public ArrayList<ModelClass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ModelClass> articles) {
        this.articles = articles;
    }
}
