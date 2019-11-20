package com.pyrca.app.carbono;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SearchActivity extends Activity {

    private Repository repo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_container);

        this.repo = Repository.getInstance();

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Log.d("TAG", query);

            //filtrar albumes
            //esta funcion setea el album filter de la BD
            repo.setAlbumsFilter(query);
            Album filter = repo.filter;

            Log.d("TAG", filter.toString());

            //llamo main activity con la lista de albumes
            Intent intentMainActivity = new Intent(this,MainActivity.class);
            intentMainActivity.putExtra("EXTRA_ALBUM_DESCRIPTION","["+query+"]");
            intentMainActivity.putExtra("EXTRA_ALBUM_COVER",filter.getImage());
            this.startActivity(intentMainActivity);
            finish();
        }
    }

}