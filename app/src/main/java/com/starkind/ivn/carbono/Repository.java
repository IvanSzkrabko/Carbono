package com.starkind.ivn.carbono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Repository {

    ArrayList<Album> albumList;

    public Repository(){
        this.albumList = new ArrayList<>();
        int[] covers = new int[]{
                R.drawable.album1,
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7};



        Album baja_aleacion = new Album("Baja Aleacion", "Acero", covers[0]);
        albumList.add(baja_aleacion);
        Album falla_forjado = new Album("Falla Forjado", "Acero", covers[1]);
        albumList.add(falla_forjado);
        Album inclusion = new Album("Inclusion", "Acero Inoxidable", covers[2], new ArrayList<>(Arrays.asList(baja_aleacion,falla_forjado)));
        albumList.add(inclusion);
        Album soldadura_defectuosa = new Album("Soldadura Defectuosa", "Acero", covers[3],new ArrayList<>(Arrays.asList(inclusion)));
        albumList.add(soldadura_defectuosa);
        Album soldadura_zac = new Album("Soldadura ZAC", "Acero", covers[4], new ArrayList<>(Arrays.asList(baja_aleacion,falla_forjado)));
        albumList.add(soldadura_zac);
        Album estructura_de_bandas = new Album("Estructura en Bandas", "Acero", covers[5]);
        albumList.add(estructura_de_bandas);
        Album tt_defectuoso = new Album("TT Defectuoso", "Acero", covers[6]);
        albumList.add(tt_defectuoso);
        Album ferrosos = new Album("Ferrosos","Ferrosos",R.drawable.cover,new ArrayList<>(Arrays.asList(soldadura_defectuosa,estructura_de_bandas,tt_defectuoso)));
        albumList.add(ferrosos);
        Album no_ferrosos = new Album("No ferrosos","No ferrosos",R.drawable.cover);
        albumList.add(no_ferrosos);
        albumList.add(new Album("Todos","Todos",R.drawable.cover,new ArrayList<>(Arrays.asList(ferrosos,no_ferrosos))));

    }

    public ArrayList<Album> getAllAlbum(){
        return albumList;
    }

    public ArrayList<Album> getSubAlbums(String description) {
        for (Album album: this.albumList) {
            if(album.getDescription().equalsIgnoreCase(description)){
                return album.getSubAlbum();
            }
        }
        return new ArrayList<>();
    }
}
