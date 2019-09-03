package com.starkind.ivn.carbono;

import java.util.ArrayList;

public class Album {
    private String description;
    private String material;
    private int image;
    private ArrayList<Album> subAlbums;

    public Album() {
        subAlbums = new ArrayList<>();
    }

    public Album(String description, String material, int image) {
        this();
        this.setDescription(description);
        this.setImage(image);
        this.setMaterial(material);
        this.setSubAlbum(new ArrayList<Album>());
    }

    public Album(String description, String material, int image, ArrayList<Album> Albums) {
        this(description,material,image);
        this.setSubAlbum(Albums);
    }

    private void setMaterial(String material) {
        this.material = material;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public String getMaterial() {
        return material;
    }

    public int getImage() {
        return image;
    }

    private void setImage(int image) {
        this.image = image;
    }

    public ArrayList<Album> getSubAlbum() {
        return this.subAlbums;
    }

    private void setSubAlbum(ArrayList<Album> albums) {
        this.subAlbums.addAll(albums);
    }
}