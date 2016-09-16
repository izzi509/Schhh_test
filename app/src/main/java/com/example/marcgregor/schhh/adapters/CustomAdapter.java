package com.example.marcgregor.schhh.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marcgregor.schhh.Hotel;
import com.example.marcgregor.schhh.HotelsActivity;
import com.example.marcgregor.schhh.PicassoClient;
import com.example.marcgregor.schhh.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Delva on 9/9/2016.
 */

public class CustomAdapter  extends BaseAdapter{
    Context c;
    ArrayList<Hotel> hotels;
    String pathImage;
    public CustomAdapter(Context c, ArrayList<Hotel> hotels) {
        this.c = c;
        this.hotels = hotels;
    }
    @Override
    public int getCount() {
        return hotels.size();
    }
    @Override
    public Object getItem(int i) {
        return hotels.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view=LayoutInflater.from(c).inflate(R.layout.item_hotel_list,viewGroup,false);
        }
        TextView tvTitle= (TextView) view.findViewById(R.id.tvTitle);
        TextView tvAdress= (TextView) view.findViewById(R.id.tvAddress);
        ImageView img= (ImageView) view.findViewById(R.id.ivImage);

        ImageView imgClass = (ImageView) view.findViewById(R.id.ivClass);

        // TextView usernameTxt= (TextView) view.findViewById(R.id.usernameTxt);
        Hotel hotel= (Hotel) this.getItem(i);
        final String nom=hotel.getNom();
        final String adresse=hotel.getAdresse();
        final String imagePath=hotel.getImagePath();
        final String nbrClass = hotel.getClassHotel();

        tvTitle.setText(nom);
        tvAdress.setText(adresse);

        if(nbrClass == "5"){
            Picasso.with(c).load(R.drawable.choublack5).into(imgClass);
        }
        else if(nbrClass == "4"){
            Picasso.with(c).load(R.drawable.choublack4).into(imgClass);
        }
        else if(nbrClass == "3"){
            Picasso.with(c).load(R.drawable.choublack3).into(imgClass);
        }
        else if(nbrClass == "2"){
            Picasso.with(c).load(R.drawable.choublack2).into(imgClass);
        }
        else if(nbrClass == "1"){
            Picasso.with(c).load(R.drawable.choublack1).into(imgClass);
        }
        else{
            Picasso.with(c).load(R.drawable.choublack1).into(imgClass);
        }

        PicassoClient.downloadImage(c, imagePath, img);

        // usernameTxt.setText(username);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //OPEN DETAIL ACTIVITY
                pathImage = imagePath;
                openHotelActivity(nom,adresse, pathImage);
            }
        });
        return view;
    }
    ////open activity
    private void openHotelActivity(String...details)
    {
        Intent i=new Intent(c,HotelsActivity.class);
        i.putExtra("NAME_KEY",details[0]);
        i.putExtra("ADRESS_KEY",details[1]);
       i.putExtra("IMAGE_KEY",details[2]);
        c.startActivity(i);
    }
}