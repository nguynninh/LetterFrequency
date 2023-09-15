package com.nguyenninh.letterfrequency.entity;

public class Entity {
    private Character text;
    public Integer price;

    public Entity(Character text, Integer price) {
        this.text = text;
        this.price = price;
    }

    public Character getText() {
        return text;
    }

    public void setText(Character text) {
        this.text = text;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return text + ": " + price;
    }
}
