package com.agel.kumar.akhil.doma.ccet_ipd;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView infoTextview;


    //#########################################

    public static Context contextOfApplication;

    public static Context getContextOfApplication() {
        return contextOfApplication;
    }


    //#########################################


    // outside onCreate

   /* @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }





//inside onCreate


    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);*/


    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomView);
        //infoTextview = (TextView)findViewById(R.id.infoTextView);






       // checknet();




    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx







        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this , mDrawerLayout, R.string.open , R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView n = (NavigationView)findViewById(R.id.navigaton_view);
        n.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                Fragment selectedFragment = null;

              /*  if(id == R.id.home){
                    mDrawerLayout.closeDrawers();

                    // Toast.makeText(MainActivity.this , "home" , Toast.LENGTH_SHORT).show();
                    selectedFragment = Home.newInstance();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, selectedFragment);
                    transaction.commit();


                    *//*Activity a = MainActivity.this;

                    Intent myIntent = new Intent(a, MainActivity.class);
                    //myIntent.putExtra("key", value); //Optional parameters
                    a.finish();
                    MainActivity.this.startActivity(myIntent);*//*
                    return true;

                    //Toast.makeText(MainActivity.this , "website" , Toast.LENGTH_SHORT).show();

                }*/
                if(id == R.id.website){

                    mDrawerLayout.closeDrawers();

                    // Toast.makeText(MainActivity.this , "home" , Toast.LENGTH_SHORT).show();
                    selectedFragment = website.newInstance();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, selectedFragment);
                    transaction.commit();
                    return true;
                    //Toast.makeText(MainActivity.this , "website" , Toast.LENGTH_SHORT).show();



                }
                if(id == R.id.reachus){

                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("http://maps.google.com/maps?daddr=Chandigarh college of engineering and technology degree wing"));
                    startActivity(intent);
                    return true;



                }

                if(id == R.id.contactus){

                    // Toast.makeText(getContext() , "contactus" , Toast.LENGTH_SHORT).show();
                    mDrawerLayout.closeDrawers();

                    // Toast.makeText(getContext() , "home" , Toast.LENGTH_SHORT).show();
                    selectedFragment = contactUs.newInstance();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, selectedFragment);
                    transaction.commit();
                    return true;
                }

                if(id == R.id.developer){

                    // Toast.makeText(getContext() , "developer" , Toast.LENGTH_SHORT).show();
                    mDrawerLayout.closeDrawers();

                    // Toast.makeText(getContext(), "home" , Toast.LENGTH_SHORT).show();
                    selectedFragment = developer.newInstance();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, selectedFragment);
                    transaction.commit();
                    return true;
                }

                if(id == R.id.admin){

                    // Toast.makeText(getContext() , "developer" , Toast.LENGTH_SHORT).show();


                    // Toast.makeText(getContext(), "home" , Toast.LENGTH_SHORT).show();

                    Activity a = MainActivity.this;

                    Intent myIntent = new Intent(a, Admin.class);
                    //myIntent.putExtra("key", value); //Optional parameters
                   // a.finish();
                    MainActivity.this.startActivity(myIntent);
                    return true;
                }



                return false;
            }
        });



//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
















        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment = null;


                if (item.getItemId() == R.id.homeItem) {
                   // checknet();

                    selectedFragment = Home.newInstance();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, selectedFragment);
                    transaction.commit();
                    return true;

                    // infoTextview.setText(R.string.home);
                } else if (item.getItemId() == R.id.eventItem) {
                    //checknet();

                    selectedFragment = Event.newInstance();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, selectedFragment);
                    transaction.commit();
                    return true;
                    // infoTextview.setText(R.string.event);
                } else if (item.getItemId() == R.id.rulesItem) {
                   // checknet();

                    selectedFragment = Rules.newInstance();

                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, selectedFragment);
                    transaction.commit();
                    return true;
                    // infoTextview.setText(R.string.rules);
                } else if (item.getItemId() == R.id.registerItem) {
                   // checknet();



                    contextOfApplication = getApplicationContext();


                    if (ContextCompat.checkSelfPermission(MainActivity.this,
                            android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                       // Toast.makeText(MainActivity.this, "You have already granted this permission!",Toast.LENGTH_SHORT).show();

                        //setContentView(R.layout.activity_main);


                        selectedFragment = Register.newInstance();

                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;


                    } else {
                        //checknet();

                        requestStoragePermission();
                    }


                } else if (item.getItemId() == R.id.developItem) {
                    //checknet();

                    selectedFragment = Team.newInstance();
                    //  infoTextview.setText(R.string.team);

                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, selectedFragment);
                    transaction.commit();
                    return true;
                }


                /*FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, selectedFragment);
                transaction.commit();*/
                return true;
            }

        });


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, Home.newInstance());
        transaction.commit();


    }






    private void requestStoragePermission() {

       /* Log.d("aaaaaaaaa" , "" + ActivityCompat.shouldShowRequestPermissionRationale(this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE));
*/


        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE)) {



            ActivityCompat.requestPermissions(this,
                    new String[] {android.Manifest.permission.READ_EXTERNAL_STORAGE}, 999);



        } else {
            ActivityCompat.requestPermissions(this,
                    new String[] {android.Manifest.permission.READ_EXTERNAL_STORAGE}, 999);
        }
    }




    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        Fragment selectedFragment = null;

        if (requestCode == 999)  {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
               // Toast.makeText(MainActivity.this, "Permission GRANTED", Toast.LENGTH_SHORT).show();
                // setContentView(R.layout.activity_main);
                selectedFragment = Register.newInstance();

            } else {

               // Toast.makeText(MainActivity.this, "Permission DENIED", Toast.LENGTH_SHORT).show();
                // setContentView(main2);


                selectedFragment = appinfo.newInstance();

                    }





            }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, selectedFragment);
        transaction.commit();


    }






  //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

      if(mToggle.onOptionsItemSelected(item)){

          return true;
      }
      return super.onOptionsItemSelected(item);
  }







    @Override
    public void onBackPressed() {


        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        MainActivity.super.onBackPressed();
                    }
                }).create().show();
    }


}
