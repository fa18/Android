package com.example.fabienfontaine.listedecourses;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class MagasinsFragment extends Fragment {


    public MagasinsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.content_magasins, container, false);
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(view.getContext(),AjoutMagasin.class),90);
            }
        });
        return v;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case 90:
                if (resultCode == RESULT_OK) {
                    String res = data.getStringExtra("NOM_MAGASIN");

                    Toast t = Toast.makeText(getActivity(), res, Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER,0,-100);
                    t.show();
                }
                break;
            
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(null);
    }
}
