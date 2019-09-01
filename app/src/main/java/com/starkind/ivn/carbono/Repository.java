package com.starkind.ivn.carbono;

import java.util.ArrayList;

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

        albumList.add(new Album("Baja Aleacion", "Acero", covers[0]));
        albumList.add(new Album("Falla Forjado", "Acero", covers[1]));
        albumList.add(new Album("Inclusion", "Acero Inoxidable", covers[2]));
        albumList.add(new Album("Soldadura Defectuosa", "Acero", covers[3]));
        albumList.add(new Album("Soldadura ZAC", "Acero", covers[4]));
        albumList.add(new Album("Estructura en Bandas", "Acero", covers[5]));
        albumList.add(new Album("TT Defectuoso", "Acero", covers[6]));
    }

    public ArrayList<Album> getAllAlbum(){
        return albumList;
    }
}
