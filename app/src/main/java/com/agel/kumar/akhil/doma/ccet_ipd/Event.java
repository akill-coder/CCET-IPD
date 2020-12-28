package com.agel.kumar.akhil.doma.ccet_ipd;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Fragment  {




    public static Event newInstance() {
        Event fragment = new Event();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event, container, false);
    }





    //##########################################################################

    private TextView txtTimerDay, txtTimerHour, txtTimerMinute, txtTimerSecond;
    private TextView tvEvent;
    private Handler handler;
    private Runnable runnable;
    private ProgressBar pb;





    public String date="add";

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){


        txtTimerDay = (TextView) getView().findViewById(R.id.txtTimerDay);
        txtTimerHour = (TextView)getView(). findViewById(R.id.txtTimerHour);
        txtTimerMinute = (TextView) getView().findViewById(R.id.txtTimerMinute);
        txtTimerSecond = (TextView) getView().findViewById(R.id.txtTimerSecond);
        tvEvent = (TextView)getView(). findViewById(R.id.tvhappyevent);
        pb = getView().findViewById(R.id.pb);

        pb.setVisibility(View.VISIBLE);


        Invisiblemake();

        DatabaseReference rootRef , demoRef;


        rootRef = FirebaseDatabase.getInstance().getReference();

        demoRef = rootRef.child("dates");

        demoRef.child("date").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                date = dataSnapshot.getValue(String.class);
                //Toast.makeText(getActivity() , date , Toast.LENGTH_SHORT).show();




                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        handler.postDelayed(this, 1000);
                        try {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
// Please here set your event date//YYYY-MM-DD
                            Date futureDate = dateFormat.parse(date);
                            Date currentDate = new Date();
                            if (!currentDate.after(futureDate)) {


                                pb.setVisibility(View.INVISIBLE);
                                visiblemake();
                                long diff = futureDate.getTime()
                                        - currentDate.getTime();
                                long days = diff / (24 * 60 * 60 * 1000);
                                diff -= days * (24 * 60 * 60 * 1000);
                                long hours = diff / (60 * 60 * 1000);
                                diff -= hours * (60 * 60 * 1000);
                                long minutes = diff / (60 * 1000);
                                diff -= minutes * (60 * 1000);
                                long seconds = diff / 1000;
                                txtTimerDay.setText("" + String.format("%02d", days));
                                txtTimerHour.setText("" + String.format("%02d", hours));
                                txtTimerMinute.setText(""
                                        + String.format("%02d", minutes));
                                txtTimerSecond.setText(""
                                        + String.format("%02d", seconds));
                            } else {



                                pb.setVisibility(View.INVISIBLE);
                                tvEvent.setVisibility(View.VISIBLE);
                       /* tvEvent.setText("The event started!");*/
                                textViewGone();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                handler.postDelayed(runnable, 1 * 1000);





            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });












        Gallery gallery = (Gallery)getView().findViewById(R.id.gallery);
        final ImageView selectedImage=(ImageView)getView().findViewById(R.id.imageView);



        gallery.setSpacing(1);
        final GalleryImageAdapter galleryImageAdapter= new GalleryImageAdapter(getActivity());
        gallery.setAdapter(galleryImageAdapter);


        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // show the selected Image
                selectedImage.setImageResource(galleryImageAdapter.mImageIds[position]);
            }
        });


      /*  txtTimerDay = (TextView) getView().findViewById(R.id.txtTimerDay);
        txtTimerHour = (TextView)getView(). findViewById(R.id.txtTimerHour);
        txtTimerMinute = (TextView) getView().findViewById(R.id.txtTimerMinute);
        txtTimerSecond = (TextView) getView().findViewById(R.id.txtTimerSecond);
        tvEvent = (TextView)getView(). findViewById(R.id.tvhappyevent);*/
        //countDownStart();





    }

    public void countDownStart() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
// Please here set your event date//YYYY-MM-DD
                    Date futureDate = dateFormat.parse("2018-" + "8" + "-" + "04");
                    Date currentDate = new Date();
                    if (!currentDate.after(futureDate)) {
                        long diff = futureDate.getTime()
                                - currentDate.getTime();
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;
                        txtTimerDay.setText("" + String.format("%02d", days));
                        txtTimerHour.setText("" + String.format("%02d", hours));
                        txtTimerMinute.setText(""
                                + String.format("%02d", minutes));
                        txtTimerSecond.setText(""
                                + String.format("%02d", seconds));
                    } else {
                        tvEvent.setVisibility(View.VISIBLE);
                       /* tvEvent.setText("The event started!");*/
                        textViewGone();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 1 * 1000);
    }




    public void textViewGone() {
        getView().findViewById(R.id.LinearLayout10).setVisibility(View.GONE);
        getView().findViewById(R.id.LinearLayout11).setVisibility(View.GONE);
        getView().findViewById(R.id.LinearLayout12).setVisibility(View.GONE);
        getView().findViewById(R.id.LinearLayout13).setVisibility(View.GONE);
        getView().findViewById(R.id.textView1).setVisibility(View.GONE);
        getView().findViewById(R.id.textView2).setVisibility(View.GONE);
    }

    public void visiblemake(){

        getView().findViewById(R.id.LinearLayout10).setVisibility(View.VISIBLE);
        getView().findViewById(R.id.LinearLayout11).setVisibility(View.VISIBLE);
        getView().findViewById(R.id.LinearLayout12).setVisibility(View.VISIBLE);
        getView().findViewById(R.id.LinearLayout13).setVisibility(View.VISIBLE);
        getView().findViewById(R.id.textView1).setVisibility(View.VISIBLE);
        getView().findViewById(R.id.textView2).setVisibility(View.VISIBLE);


    }

    public void Invisiblemake(){

        getView().findViewById(R.id.LinearLayout10).setVisibility(View.INVISIBLE);
        getView().findViewById(R.id.LinearLayout11).setVisibility(View.INVISIBLE);
        getView().findViewById(R.id.LinearLayout12).setVisibility(View.INVISIBLE);
        getView().findViewById(R.id.LinearLayout13).setVisibility(View.INVISIBLE);
        getView().findViewById(R.id.textView1).setVisibility(View.INVISIBLE);
        getView().findViewById(R.id.textView2).setVisibility(View.INVISIBLE);


    }
}








