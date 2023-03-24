package com.bootcamp.agenciadeviajes.model;

public class Viajes {
    private String name;
    private int picture;

    public Viajes(){

    }
    public Viajes(String name, int picture) {
        this.name = name;
        this.picture = picture;
    }

    public String getName(String name) {
        return name;}

    public void setName(String name) {
        this.name = name;    }

    public int getPicture() {
        return picture;    }

    public void setPicture(int picture) {
        this.picture = picture;    }
}
