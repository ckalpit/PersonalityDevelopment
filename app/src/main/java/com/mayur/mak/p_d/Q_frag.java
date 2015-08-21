package com.mayur.mak.p_d;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.net.Uri;
import android.widget.Gallery;
import android.os.Bundle;
//import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import static android.support.v7.internal.widget.TintTypedArray.obtainStyledAttributes;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Q_frag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Q_frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Q_frag extends Fragment {



    Integer[] imageIDs = {
            com.mayur.mak.p_d.R.drawable.ic_drawer,
            com.mayur.mak.p_d.R.drawable.ic_drawer,
            com.mayur.mak.p_d.R.drawable.ic_launcher,
            com.mayur.mak.p_d.R.drawable.ic_drawer,
            com.mayur.mak.p_d.R.drawable.ic_drawer,
            com.mayur.mak.p_d.R.drawable.ic_drawer,
            com.mayur.mak.p_d.R.drawable.ic_launcher
    };

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Q_frag.
     */
    // TODO: Rename and change types and number of parameters
    public static Q_frag newInstance(String param1, String param2) {
        Q_frag fragment = new Q_frag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Q_frag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = null;

        v = inflater.inflate(com.mayur.mak.p_d.R.layout.fragment_frag__b, container, false);
        Gallery gallery = (Gallery)v.findViewById(com.mayur.mak.p_d.R.id.gallery1);


        gallery.setAdapter(new ImageAdapter(v.getContext()));//this

        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position,long id)
            {
               // Toast.makeText(getBaseContext(), "pic" + (position + 1) + " selected",
                //        Toast.LENGTH_SHORT).show();
                // display the images selected
                ImageView imageView = (ImageView)v.findViewById(com.mayur.mak.p_d.R.id.image1);
                imageView.setImageResource(imageIDs[position]);
            }
        });

        return v;
    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;
        private int itemBackground;
        public ImageAdapter(Context c)
        {
            context = c;
            // sets a grey background; wraps around the images
           // TypedArray a =obtainStyledAttributes(R.styleable.MyGallery);
          //  itemBackground = a.getResourceId(R.styleable.MyGallery_android_galleryItemBackground, 0);
           // a.recycle();
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




    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
