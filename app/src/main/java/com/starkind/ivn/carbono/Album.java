package com.starkind.ivn.carbono;

import java.util.ArrayList;

public class Album {
    private String description;
    private String material;
    private String tag_imagen;
    private int image;
    private ArrayList<Album> subAlbums;
    private boolean show_me;

    public Album() {
        subAlbums = new ArrayList<>();
    }

    public Album(boolean show_me,String description, String material, int image) {
        this();
        this.setDescription(description);
        this.setImage(image);
        this.SetTagImagen(String.valueOf(image));
        this.setMaterial(material);
        this.setSubAlbum(new ArrayList<Album>());
        this.setShow_me(show_me);
    }

    public Album(boolean show_me,String description, String material, int image, ArrayList<Album> Albums) {
        this(show_me,description,material,image);
        this.setSubAlbum(Albums);

    }

    private void setShow_me(boolean show_me){this.show_me=show_me;}

    public boolean getShow_me(){return(show_me);}

    private void setMaterial(String material) {
        this.material = material;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void SetTagImagen(String imagen) {
        this.tag_imagen = imagen;
    }

    public String getTag_Imagen() {
        return tag_imagen;
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