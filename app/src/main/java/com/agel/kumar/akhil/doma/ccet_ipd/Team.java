package com.agel.kumar.akhil.doma.ccet_ipd;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class Team extends Fragment implements View.OnClickListener {
    public static Team newInstance() {
        Team fragment = new Team();
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_team, container, false);





    }


    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {

    Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.principal);
        Bitmap circularBitmap = ImageConverter.getRoundedCornerBitmap(bitmap, 100);

        ImageView circularImageView = (ImageView)getView().findViewById(R.id.one);
        //circularImageView.setImageBitmap(circularBitmap);
        circularImageView.setOnClickListener(this);


        Bitmap bitmap1 = BitmapFactory.decodeResource(this.getResources(),R.drawable.x);
        Bitmap circularBitmap1 = ImageConverter.getRoundedCornerBitmap(bitmap1, 100);

        ImageView circularImageView1 = (ImageView)getView().findViewById(R.id.three);
        //circularImageView1.setImageBitmap(circularBitmap1);
        circularImageView1.setOnClickListener(this);


        Bitmap bitmap2 = BitmapFactory.decodeResource(this.getResources(),R.drawable.z);
        Bitmap circularBitmap2 = ImageConverter.getRoundedCornerBitmap(bitmap2, 100);

        ImageView circularImageView2 = (ImageView)getView().findViewById(R.id.two);
        //circularImageView2.setImageBitmap(circularBitmap2);
        circularImageView2.setOnClickListener(this);






    }



    public void onClick(View v) {





        final Dialog myDialog = new Dialog(getContext());
        myDialog.setContentView(R.layout.popup);

        TextView name = (TextView)myDialog.findViewById(R.id.nameTeam);
        TextView desig = myDialog.findViewById(R.id.designation);
        TextView con = myDialog.findViewById(R.id.contactid);

        switch (v.getId()) {

            case R.id.one:
            {

                name.setText("DR. MANPREET SINGH GUJRAL ");
                desig.setText("PRINCIPAL – CCET");
                con.setText("principal@ccet.ac.in");
            }

                break;

            case R.id.three: {
             name.setText("    DR. D. S. SAINI      ");
                desig.setText("PROFESSOR IN-CHARGE – IIEDC");
                con.setText("dssaini@ccet.ac.in");
            }


            break;

            case R.id.two: {


         name.setText("   DR. ASHWANI KUMAR     ");
                desig.setText("IIEDC – COORDINATOR");
                con.setText("ashwanikumar@ccet.ac.in");
            }


            break;

            default:
                break;
        }


        TextView txtclose;


        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("X");

        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
       myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }








}
