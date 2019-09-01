package com.starkind.ivn.carbono;

public class Album {
    private String name;
    private String material;
    private int image;

    public Album() {
    }

    public Album(String name, String material, int image) {
        this.setName(name);
        this.setImage(image);
        this.setMaterial(material);
    }

    private void setMaterial(String material) {
        this.material = material;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}