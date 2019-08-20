package com.starkind.ivn.carbono;

public class Album {
    private String name;
    private String material;
    private int thumbnail;

    public Album() {
    }

    public Album(String name, String material, int thumbnail) {
        this.name = name;
        this.material = material;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}