package com.example.recyclerviewexample;

public class Number {

    private int number ;
    private int imageId ;

    public Number(int number) {
        this.number = number;
    }

    public Number(int number, int imageId) {
        this.number = number;
        this.imageId = imageId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
