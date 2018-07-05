package com.calone.vpgilt.Utils;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by babas on 03/07/18.
 */

public class ImageLoaderUtils {

    public static void loadImage(String url, ImageView imageView) {
        Picasso.get().load(url).into(imageView);
    }
}
