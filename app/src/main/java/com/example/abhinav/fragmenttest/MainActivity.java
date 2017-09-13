package com.example.abhinav.fragmenttest;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    public boolean landscape;
    private boolean tilted=false;
    FragmentA fragmentA=new FragmentA();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            //Restore the fragment's instance
            fragmentA = (FragmentA) getFragmentManager().getFragment(savedInstanceState, "myFragmentName");
        }
        else{
            fragmentA=new FragmentA();
        }
        if(getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE)
        {
            landscape =true;
        }
        else{
            landscape =false;
        }

        getFragmentManager().beginTransaction().replace(R.id.frameLayout,fragmentA).commit();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Save the fragment's instance
        getFragmentManager().putFragment(outState, "myFragmentName", fragmentA);
    }
}
