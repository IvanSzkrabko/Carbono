package com.pyrca.app.carbono;

import java.util.ArrayList;
import java.util.Arrays;

public class Repository {

    ArrayList<Album> albumList;
    Album filter;
    private static Repository SINGLE_INSTANCE = null;


    public static Repository getInstance() {
        if (SINGLE_INSTANCE == null) {
            synchronized(Repository.class) {
                SINGLE_INSTANCE = new Repository();
            }
        }
        return SINGLE_INSTANCE;
    }

    private Repository(){
        this.albumList = new ArrayList<>();
        int[] covers = new int[]{
                R.drawable.album1,
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.acerosae1040};



        Album baja_aleacion = new Album(1,"",true,"Estructura en Bandas", "Acero Baja Aleacion", covers[0]);
        albumList.add(baja_aleacion);

        Album falla_forjado = new Album(2,"",true,"Falla Forjado", "Acero Alta Aleacion", covers[1]);
        albumList.add(falla_forjado);

        Album inclusion = new Album(3,"",true,"Inclusion", "Acero Inoxidable", covers[2]);
        albumList.add(inclusion);

        Album soldadura_defectuosa = new Album(4,"",true,"Soldadura Multipasada Defectuosa", "Acero Inoxidable", covers[7]);
        albumList.add(soldadura_defectuosa);

        Album soldadura_zac = new Album(5,"",true,"Soldadura ZAC", "Acero Alta Aleacion", covers[3]);
        albumList.add(soldadura_zac);

        Album estructura_de_bandas = new Album(6,"",true,"Estructura en Banda", "Acero Alta Aleacion", covers[4]);
        albumList.add(estructura_de_bandas);

        Album tt_defectuoso = new Album(7,"",true,"TT Defectuoso", "Acero Baja Aleacion", covers[5]);
        albumList.add(tt_defectuoso);

        Album tt_normalizado = new Album(8,"",true,"Falla Normalizado", "Acero Alta Aleacion", covers[6]);
        albumList.add(tt_normalizado);

        Album acerosae1040 = new Album(1421,"Se puede observar, a x100 aumentos una estructura homogénea, con un tamaño de grano N6 (según Norma IRAM-IAS U500-122)." +
                "La probeta fue atacada con Nital al 2% permitiendo la clara observación del borde de grano." +
                "Se puede diferenciar con gran facilidad, los granos ferríticos(de color claro), de los granos perlíticos(de color obscuro).",true,"Atacado con Nital", "Acero", covers[7]);
        albumList.add(acerosae1040);

        Album AceroAA = new Album(0,"",false,"Aceros Alta Aleacion","",R.drawable.xalta_aleacion,new ArrayList<>(Arrays.asList(falla_forjado,soldadura_zac,estructura_de_bandas,tt_normalizado,acerosae1040)));
        albumList.add(AceroAA);

        Album AceroBA = new Album(0,"",false,"Aceros Baja Aleacion","",R.drawable.xbaja_aleacion,new ArrayList<>(Arrays.asList(baja_aleacion,tt_defectuoso)));
        albumList.add(AceroBA);

        Album AceroInox = new Album(0,"",false,"Acero Inoxidable","",R.drawable.xinoxidable,new ArrayList<>(Arrays.asList(inclusion,soldadura_defectuosa)));
        albumList.add(AceroInox);

        Album Aceros = new Album(0,"",false,"Aceros","",R.drawable.xaceros,new ArrayList<>(Arrays.asList(AceroBA,AceroAA,AceroInox)));
        albumList.add(Aceros);

        Album FundicionGris = new Album(0,"",true,"Fundicion Gris","",R.drawable.xfund_gris);
        albumList.add(FundicionGris);

        Album FundicionNodular = new Album(0,"",true,"Fundicion Nodular","",R.drawable.xfund_nodular);
        albumList.add(FundicionNodular);

        Album FundicionBlanca = new Album(0,"",true,"Fundicion Blanca","",R.drawable.xfund_blanca);
        albumList.add(FundicionBlanca);

        Album Fundicion = new Album(0,"",false,"Fundicion","",R.drawable.xfundicion,new ArrayList<>(Arrays.asList(FundicionGris,FundicionNodular,FundicionBlanca)));
        albumList.add(Fundicion);

        Album ferrosos = new Album(0,"",false,"Ferrosos","",R.drawable.ferroso,new ArrayList<>(Arrays.asList(Aceros,Fundicion)));
        albumList.add(ferrosos);

        Album no_ferrosos = new Album(0,"",false,"No ferrosos","",R.drawable.noferroso);
        albumList.add(no_ferrosos);

        Album index = new Album(0,"",false,"Metales","",R.drawable.index,new ArrayList<>(Arrays.asList(ferrosos,no_ferrosos)));
        albumList.add(index);

        this.filter = new Album(-1,"",false,"Filter","Filter",R.drawable.filter);
        albumList.add(this.filter);

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

    public void setAlbumsFilter(String search){
        ArrayList<Album> albums = new ArrayList<>();
        for (Album album: this.albumList) {
            if(containsInDescriptionAndMaterial(album,search)&&album.getShow_me()){
                albums.add(album);
            }
        }
        filter.setSubAlbum(albums);
        filter.setDescription("["+search+"]");
    }

    private boolean containsInDescriptionAndMaterial(Album album, String subString) {
        return album.getDescription().toLowerCase().contains(subString.toLowerCase()) ||
                album.getMaterial().toLowerCase().contains(subString.toLowerCase());
    }
}
