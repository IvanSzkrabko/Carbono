package com.starkind.ivn.carbono;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {

    private Context mContext;
    private List<Album> albumList;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView description, material,tag_imagen,long_description;
        ImageView image, overflow;

        MyViewHolder(View view) {
            super(view);
            description =  view.findViewById(R.id.description);
            material =  view.findViewById(R.id.material);
            tag_imagen =  view.findViewById(R.id.tag_imagen);
            image = view.findViewById(R.id.image);
            overflow = view.findViewById(R.id.overflow);
        }
    }

    AlbumsAdapter(Context mContext, List<Album> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,MainActivity.class);
                intent.putExtra("EXTRA_ALBUM_DESCRIPTION",((TextView)itemView.findViewById(R.id.description)).getText());
                intent.putExtra("EXTRA_ALBUM_COVER",((TextView)itemView.findViewById(R.id.tag_imagen)).getText());
                //Toast.makeText(mContext, (((TextView) itemView.findViewById(R.id.tag_imagen)).getText()), Toast.LENGTH_SHORT).show();
                mContext.startActivity(intent);
            }

        });

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        final Album album = albumList.get(position);

        album.getDescription();
        holder.description.setText(album.getDescription());
        holder.material.setText(album.getMaterial());
        holder.tag_imagen.setText(album.getTag_Imagen());
        // loading album cover using Glide library
        Glide.with(mContext).load(album.getImage()).into(holder.image);
        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,MainActivity.class);
                intent.putExtra("EXTRA_ALBUM_DESCRIPTION",album.getDescription());
                intent.putExtra("EXTRA_ALBUM_COVER",album.getTag_Imagen());
                intent.putExtra("EXTRA_ALBUM_LONG_DESC",album.getLongDescription());
                intent.putExtra("EXTRA_ALBUM_PROBETA",album.getProbeta());
                mContext.startActivity(intent);
            }
        });

        holder.image.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //Toast.makeText(mContext, String.valueOf(album.getImage()), Toast.LENGTH_SHORT).show();
                if(album.getShow_me()) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, ImageViewer.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("album_clicked", (int) album.getImage());
                    context.startActivity(intent);
                    return (true);
                }
                return(false);
            }
        });



    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        MyMenuItemClickListener() {
        }
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Guardar", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Compartir", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}