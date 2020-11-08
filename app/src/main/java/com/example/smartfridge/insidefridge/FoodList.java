package com.example.smartfridge.insidefridge;

public class FoodList {
    private String title, date, ID;
    private Integer amount;

    public FoodList() {
        this.title = "";
        this.amount = 0;
        this.date = "";
        this.ID = "";
    }

    public FoodList(String title, int amount, String date, int randInt) {
        this.title = title;
        this.amount = amount;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean equals(FoodList list) {
        return list.ID.equals(this.ID);
    }

    public boolean hasSameId(String id) { return id.equals(this.ID); }
}
