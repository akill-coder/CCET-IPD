package com.agel.kumar.akhil.doma.ccet_ipd;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Home extends Fragment {
    public static Home newInstance() {
        Home fragment = new Home();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

   /* private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mDrawerLayout = (DrawerLayout)getView().findViewById(R.id.drawer);






        mToggle = new ActionBarDrawerToggle(getActivity() , mDrawerLayout, R.string.open , R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView n = (NavigationView)getView().findViewById(R.id.navigaton_view);
        n.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                Fragment selectedFragment = null;

                if(id == R.id.home){
                    mDrawerLayout.closeDrawers();

                    // Toast.makeText(MainActivity.this , "home" , Toast.LENGTH_SHORT).show();
                    selectedFragment = Home.newInstance();
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, selectedFragment);
                    transaction.commit();
                    return true;
                    //Toast.makeText(MainActivity.this , "website" , Toast.LENGTH_SHORT).show();

                }
                if(id == R.id.website){

                    mDrawerLayout.closeDrawers();

                   // Toast.makeText(MainActivity.this , "home" , Toast.LENGTH_SHORT).show();
                    selectedFragment = website.newInstance();
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout2, selectedFragment);
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
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout2, selectedFragment);
                    transaction.commit();
                    return true;
                }

                if(id == R.id.developer){

                   // Toast.makeText(getContext() , "developer" , Toast.LENGTH_SHORT).show();
                    mDrawerLayout.closeDrawers();

                   // Toast.makeText(getContext(), "home" , Toast.LENGTH_SHORT).show();
                    selectedFragment = developer.newInstance();
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout2, selectedFragment);
                    transaction.commit();
                    return true;
                }



                return false;
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item)){

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

*/
    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx



}
