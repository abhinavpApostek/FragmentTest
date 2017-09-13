package com.example.abhinav.fragmenttest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Abhinav on 8/22/2017.
 */

public class FragmentB extends Fragment {



    public static FragmentB getInstance(String arg)
    {
        FragmentB fragmentB=new FragmentB();
        Bundle bundle=new Bundle();
        bundle.putString("argument",arg);
        fragmentB.setArguments(bundle);
        return fragmentB;
    }
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_b,container,false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView=(TextView)view.findViewById(R.id.textView);
        textView.setText(getArguments().getString("argument","nothing is selected"));

    }
}
