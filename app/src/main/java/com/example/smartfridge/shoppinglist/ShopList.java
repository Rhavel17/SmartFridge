package com.example.smartfridge.shoppinglist;

public class ShopList {
    private String title, content, date, ID;

    public ShopList() {
        this.title = "";
        this.content = "";
        this.date = "";
        this.ID = "";
    }

    public ShopList(String title, String content, String date, int randInt) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.ID = title + " " + randInt;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean equals(ShopList list) {
        return list.ID.equals(this.ID);
    }

    public boolean hasSameId(String id) { return id.equals(this.ID); }
}
