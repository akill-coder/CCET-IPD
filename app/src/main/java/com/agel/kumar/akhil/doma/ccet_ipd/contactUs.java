package com.agel.kumar.akhil.doma.ccet_ipd;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;


public class contactUs extends Fragment {
    public static contactUs newInstance() {
        contactUs fragment = new contactUs();
        return fragment;
    }



    public CheckBox c;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact_us, container, false);


    }





}
