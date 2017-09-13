package com.example.abhinav.fragmenttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Abhinav on 8/22/2017.
 */

public class FragmentA extends Fragment implements AdapterView.OnItemClickListener {


    ListView listView;
    String x[]=new String[15];
    int i=-1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_a,container,false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView=(ListView)view.findViewById(R.id.listView);
        for(int i=0;i<15;i++)
        {
            x[i]=Integer.toString(i);
        }
        listView.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,x));
        listView.setOnItemClickListener(this);
       /* if(savedInstanceState!=null)
        {
            int x=savedInstanceState.getInt("position");
            Log.v("getposition",Integer.toString(x));
            if(x!=-1)
            {
                clickOnPosition(x);
            }
        }else{
            Log.v("saveinstance state","null");
        }*/
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        clickOnPosition(position);


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            //Restore the fragment's state here
            if(savedInstanceState!=null)
            {
                int x=savedInstanceState.getInt("position");
                Log.v("getposition",Integer.toString(x));
                if(x!=-1)
                {
                    clickOnPosition(x);
                }
            }else{
                Log.v("saveinstance state","null");
            }
        }
    }
    private void clickOnPosition(int position) {
        FragmentB fragmentB=FragmentB.getInstance((String)listView.getAdapter().getItem(position));
        i=position;

        if(((MainActivity)getActivity()).landscape) {

            getActivity().getFragmentManager().beginTransaction().replace(R.id.frameLayout2,fragmentB).commit();
            Log.v("clickonposition land",Integer.toString(position));

        }else{

            //getActivity().getFragmentManager().beginTransaction().replace(R.id.frameLayout,fragmentB).addToBackStack(null).commit();
           /* Intent intent=new Intent(getActivity(),ActivityB.class);
            intent.putExtra("argument",(String)listView.getAdapter().getItem(position));
            startActivity(intent);*/
            getActivity().getFragmentManager().beginTransaction().replace(R.id.frameLayout,fragmentB).addToBackStack(null).commit();
            Log.v("clickonposition port",Integer.toString(position));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position",i);
    }
}
