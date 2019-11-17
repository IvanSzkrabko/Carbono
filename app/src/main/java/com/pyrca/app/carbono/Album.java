package com.pyrca.app.carbono;

import java.util.ArrayList;

public class Album {
    private String description,long_description;
    private String material;
    private String tag_imagen;
    private int image,probeta;
    private ArrayList<Album> subAlbums;
    private boolean show_me;

    public Album() {
        subAlbums = new ArrayList<>();
    }

    public Album(int probeta,String long_description,boolean show_me,String description, String material, int image) {
        this();
        this.setDescription(description);
        this.setImage(image);
        this.SetTagImagen(String.valueOf(image));
        this.setMaterial(material);
        this.setSubAlbum(new ArrayList<Album>());
        this.setShow_me(show_me);
        this.setLongDescription(long_description);
        this.setProbeta(probeta);
    }

    public Album(int probeta,String long_description,boolean show_me,String description, String material, int image, ArrayList<Album> Albums) {
        this(probeta,long_description,show_me,description,material,image);
        this.setSubAlbum(Albums);

    }

    private void setShow_me(boolean show_me){this.show_me=show_me;}

    public boolean getShow_me(){return(show_me);}

    private void setMaterial(String material) {
        this.material = material;
    }

    public String getLongDescription() {
        return long_description;
    }

    private void setLongDescription(String long_description) {
        this.long_description = long_description;
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

    private void setProbeta(int probeta) {
        this.probeta = probeta;
    }

    public int getProbeta() {
        return probeta;
    }

    public ArrayList<Album> getSubAlbum() {
        return this.subAlbums;
    }

    public void setSubAlbum(ArrayList<Album> albums) {
        this.subAlbums.clear();
        this.subAlbums.addAll(albums);
    }

}