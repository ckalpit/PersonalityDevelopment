package com.mayur.mak.p_d;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

@SuppressWarnings("deprecation")
public class Qu_Activity extends Activity {

    //the images to display
    Integer[] imageIDs = {
            com.mayur.mak.p_d.R.drawable.two,
            com.mayur.mak.p_d.R.drawable.one,
            com.mayur.mak.p_d.R.drawable.three,
            com.mayur.mak.p_d.R.drawable.four,
            com.mayur.mak.p_d.R.drawable.five,
            com.mayur.mak.p_d.R.drawable.six,
            com.mayur.mak.p_d.R.drawable.seven,

            com.mayur.mak.p_d.R.drawable.eight,
            com.mayur.mak.p_d.R.drawable.nine,
            com.mayur.mak.p_d.R.drawable.ten,
            com.mayur.mak.p_d.R.drawable.eleven,
            com.mayur.mak.p_d.R.drawable.twelve,
            com.mayur.mak.p_d.R.drawable.thirteen,

            com.mayur.mak.p_d.R.drawable.fourteen,
            com.mayur.mak.p_d.R.drawable.fifteen,
            com.mayur.mak.p_d.R.drawable.sixteen,

               };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.mayur.mak.p_d.R.layout.activity_qu_);

        // Note that Gallery view is deprecated in Android 4.1---
        Gallery gallery = (Gallery) findViewById(com.mayur.mak.p_d.R.id.gallery1);
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position,long id)
            {
            //    Toast.makeText(getBaseContext(),"pic" + (position + 1) + " selected",
             //           Toast.LENGTH_SHORT).show();
                // display the images selected
                ImageView imageView = (ImageView) findViewById(com.mayur.mak.p_d.R.id.image1);
                imageView.setImageResource(imageIDs[position]);
            }
        });
    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;
        private int itemBackground;
        public ImageAdapter(Context c)
        {
            context = c;
            // sets a grey background; wraps around the images
            TypedArray a =obtainStyledAttributes(com.mayur.mak.p_d.R.styleable.MyGallery);
           // itemBackground = a.getResourceId(R.styleable.MyGallery_android_galleryItemBackground, 0);
            a.recycle();
        }
        // returns the number of images
        public int getCount() {
            return imageIDs.length;
        }
        // returns the ID of an item
        public Object getItem(int position) {
            return position;
        }
        // returns the ID of an item
        public long getItemId(int position) {
            return position;
        }
        // returns an ImageView view
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(imageIDs[position]);
            imageView.setLayoutParams(new Gallery.LayoutParams(100, 100));
            imageView.setBackgroundResource(itemBackground);
            return imageView;
        }
    }
}
