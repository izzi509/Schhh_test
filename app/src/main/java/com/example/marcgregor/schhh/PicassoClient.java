package com.example.marcgregor.schhh;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**

 */

public class PicassoClient {
    public static void downloadImage(Context c, String imagePath, ImageView ivImage) {
        if (imagePath != null && imagePath.length() > 0) {
            Picasso.with(c).load(imagePath).placeholder(R.mipmap.ic_launcher).into(ivImage);
        } else {
            Picasso.with(c).load(R.mipmap.ic_launcher).into(ivImage);
        }
    }


}