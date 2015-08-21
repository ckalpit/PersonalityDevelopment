package com.mayur.mak.p_d;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class Basic_detail extends ActionBarActivity {


    String msg =" ";
    String[] des;
    String[] tit={"Attire", "Body Language", "Courtesy", "Know Yourself", "Optimism",
            "Speech"};



    int[] images = {com.mayur.mak.p_d.R.drawable.img_attire, com.mayur.mak.p_d.R.drawable.img_bdy_l, com.mayur.mak.p_d.R.drawable.img_court, com.mayur.mak.p_d.R.drawable.img_knowur, com.mayur.mak.p_d.R.drawable.img_opti, com.mayur.mak.p_d.R.drawable.img_speech};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.mayur.mak.p_d.R.layout.basic_deatil);


//        getSupportActionBar().setHomeButtonEnabled(true);
        //       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//            callthis(String msg);

        TextView tx = (TextView) findViewById(com.mayur.mak.p_d.R.id.textView);
        ImageView iv = (ImageView) findViewById(com.mayur.mak.p_d.R.id.imageView2);


        Intent intent = getIntent();

        Resources res = getResources();
        des = res.getStringArray(com.mayur.mak.p_d.R.array.des);


        // msg = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        msg = intent.getStringExtra(Frag_A.EXTRA_MESSAGE);

        //     }
        tx.setText("" + msg);

        // Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

        int msg_int = Integer.parseInt(msg);//typecast
//int msg_int=0;

        for (int i = 0; i < 16; i++) {


            if (msg_int == i)
            {


                setTitle(tit[i]);
                tx.setText("" + des[i]);
                iv.setImageResource(images[i]);
            }
        }


    }






    }

