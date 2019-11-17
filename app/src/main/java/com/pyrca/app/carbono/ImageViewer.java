package com.pyrca.app.carbono;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.chrisbanes.photoview.PhotoView;

public class ImageViewer extends AppCompatActivity{
    public PhotoView mPhotoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_viewer);
        mPhotoView =  findViewById(R.id.imageView2);

        Bundle b = getIntent().getExtras();
        Integer id = b.getInt("album_clicked");
        mPhotoView.setImageResource(id);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==1)
        {
            finish();

        }
    }
}
