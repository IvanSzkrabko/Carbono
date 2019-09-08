package com.starkind.ivn.carbono;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.chrisbanes.photoview.PhotoView;

public class ImageViewer extends AppCompatActivity{
    public Bitmap scaled;
    public PhotoView mPhotoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_viewer);
        mPhotoView =  findViewById(R.id.imageView2);

        /*boolean islong = false;
        islong = b.getBoolean("islong");*/
        Bundle b = getIntent().getExtras();
        int id = b.getInt("album_clicked");
        //mPhotoView.setImageResource(Database.covers[id]);


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

    public void showFullScreen() {
        float photoViewWidth = mPhotoView.getWidth();
        float photoViewHeight = mPhotoView.getHeight();

        float viewScale = mPhotoView.getScale();
        RectF rect = mPhotoView.getDisplayRect();

        // Compute initial base rect
        float baseRectWidth = (rect.right - rect.left) / viewScale;
        float baseRectHeight = (rect.bottom - rect.top) / viewScale;

        // Compute medium scale for full size
        double mediumScale, currentScale;
        if (baseRectHeight > baseRectWidth) {
            mediumScale = photoViewWidth / baseRectWidth;
        } else {
            mediumScale = photoViewHeight / baseRectHeight;
        }

        mediumScale = Math.round(mediumScale * 100.0) / 100.0;
        currentScale = Math.round(mPhotoView.getScale() * 100.0) / 100.0;

        // Apply new scale: minimum or medium
        if (currentScale < mediumScale) {
            mPhotoView.setScale((float) mediumScale);

        } else {
            mPhotoView.setScale(mPhotoView.getMinimumScale());
        }
    }

}
