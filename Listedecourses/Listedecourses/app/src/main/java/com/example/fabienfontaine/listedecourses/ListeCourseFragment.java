package com.example.fabienfontaine.listedecourses;


import android.content.ContentValues;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListeCourseFragment extends Fragment {


    private ListView pUserListView;

    public ListeCourseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vue = inflater.inflate(R.layout.content_liste_course, container, false);

        pUserListView = (ListView) vue.findViewById(R.id.UserlistView);

        return vue;
    }

    @Override
    public void onResume() {
        super.onResume();
        Bdd obj = new Bdd(getContext());
        List<Prods> prods = obj.userProds();

        ListeCourseAdaptater adapter = new ListeCourseAdaptater(getContext(), prods);

        pUserListView.setAdapter(adapter);
    }
}
