package com.mayur.mak.p_d;

import android.content.Intent;
//import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.*;

import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
/**
 * Created by Mayur on 05/06/2015.
 */

public class Frag_A extends Fragment
{

    ListView listView;
    public static final String EXTRA_MESSAGE = "Message";
    private String[] mNames = { "Attire", "Body Language", "Courtesy", "Know Yourself", "Optimism",
            "Speech"};


//    private String[] mAnimals = { "Perro", "Gato", "Oveja", "Elefante", "Pez",
 //           "Nicuro", "Bocachico", "Chucha", "Curie", "Raton", "Aguila",
  //          "Leon", "Jirafa" };

    int[] flags = new int[]{
            com.mayur.mak.p_d.R.drawable.b_attire,
            com.mayur.mak.p_d.R.drawable.b_bodyl,
            com.mayur.mak.p_d.R.drawable.b_courtsy,
            com.mayur.mak.p_d.R.drawable.b_know,
            com.mayur.mak.p_d.R.drawable.b_optism,
            com.mayur.mak.p_d.R.drawable.b_speach,
             };


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i <6; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("txt","" + mNames[i]);
            //    hm.put("cur","creator : " + mAnimals[i]);
            hm.put("flag", Integer.toString(flags[i]));
            aList.add(hm);
        }
        String[] from = {"flag", "txt", "cur"};

        //     int[] to = { R.id.flag,R.id.txt,R.id.cur,R.id.textView2};
        int[] to = {com.mayur.mak.p_d.R.id.imageView, com.mayur.mak.p_d.R.id.textView1, com.mayur.mak.p_d.R.id.textView2};



        View v = inflater.inflate(com.mayur.mak.p_d.R.layout.frag_a, container, false);

        listView=(ListView)v.findViewById(com.mayur.mak.p_d.R.id.listView1);

        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // When clicked, show a toast with the TextView text
                //     Toast.makeText(getApplicationContext(),

                Intent intent =new Intent(view.getContext(),Basic_detail.class);
                String msg = Integer.toString(position);
                intent.putExtra("Message",msg);
                startActivity(intent);


            }
        });




        ListView list = (ListView)v.findViewById(com.mayur.mak.p_d.R.id.listView1);
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(),aList, com.mayur.mak.p_d.R.layout.singlerow, from, to);
        list.setAdapter(adapter);
        return v;
        //this.getBaseContext()
/*
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(arg1.getContext(),MainActivity2.class);
                startActivity(intent);

            }
        });
*/



    }



}







