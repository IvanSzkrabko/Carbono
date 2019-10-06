package com.starkind.ivn.carbono;

import java.util.ArrayList;
import java.util.Arrays;

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
                R.drawable.album7,
                R.drawable.album8};



        Album baja_aleacion = new Album(true,"Estructura en Bandas", "Acero Baja Aleacion", covers[0]);
        albumList.add(baja_aleacion);
        Album falla_forjado = new Album(true,"Falla Forjado", "Acero Alta Aleacion", covers[1]);
        albumList.add(falla_forjado);
        Album inclusion = new Album(true,"Inclusion", "Acero Inoxidable", covers[2]);
        albumList.add(inclusion);
        Album soldadura_defectuosa = new Album(true,"Soldadura Multipasada Defectuosa", "Acero Inoxidable", covers[7]);
        albumList.add(soldadura_defectuosa);
        Album soldadura_zac = new Album(true,"Soldadura ZAC", "Acero Alta Aleacion", covers[3]);
        albumList.add(soldadura_zac);
        Album estructura_de_bandas = new Album(true,"Estructura en Banda", "Acero Alta Aleacion", covers[4]);
        albumList.add(estructura_de_bandas);
        Album tt_defectuoso = new Album(true,"TT Defectuoso", "Acero Baja Aleacion", covers[5]);
        albumList.add(tt_defectuoso);
        Album tt_normalizado = new Album(true,"Falla Normalizado", "Acero Alta Aleacion", covers[6]);
        albumList.add(tt_normalizado);
        Album AceroAA = new Album(false,"Aceros Alta Aleacion","",R.drawable.xalta_aleacion,new ArrayList<>(Arrays.asList(falla_forjado,soldadura_zac,estructura_de_bandas,tt_normalizado)));
        albumList.add(AceroAA);
        Album AceroBA = new Album(false,"Aceros Baja Aleacion","",R.drawable.xbaja_aleacion,new ArrayList<>(Arrays.asList(baja_aleacion,tt_defectuoso)));
        albumList.add(AceroBA);
        Album AceroInox = new Album(false,"Acero Inoxidable","",R.drawable.xinoxidable,new ArrayList<>(Arrays.asList(inclusion,soldadura_defectuosa)));
        albumList.add(AceroInox);
        Album Aceros = new Album(false,"Aceros","",R.drawable.xaceros,new ArrayList<>(Arrays.asList(AceroBA,AceroAA,AceroInox)));
        albumList.add(Aceros);
        Album FundicionGris = new Album(true,"Fundicion Gris","",R.drawable.xfund_gris);
        albumList.add(FundicionGris);
        Album FundicionNodular = new Album(true,"Fundicion Nodular","",R.drawable.xfund_nodular);
        albumList.add(FundicionNodular);
        Album FundicionBlanca = new Album(true,"Fundicion Blanca","",R.drawable.xfund_blanca);
        albumList.add(FundicionBlanca);
        Album Fundicion = new Album(false,"Fundicion","",R.drawable.xfundicion,new ArrayList<>(Arrays.asList(FundicionGris,FundicionNodular,FundicionBlanca)));
        albumList.add(Fundicion);
        Album ferrosos = new Album(false,"Ferrosos","",R.drawable.ferroso,new ArrayList<>(Arrays.asList(Aceros,Fundicion)));
        albumList.add(ferrosos);
        Album no_ferrosos = new Album(false,"No ferrosos","",R.drawable.noferroso);
        albumList.add(no_ferrosos);
        Album index = new Album(false,"Metales","",R.drawable.index,new ArrayList<>(Arrays.asList(ferrosos,no_ferrosos)));
        albumList.add(index);
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
