package com.example.fabienfontaine.listedecourses;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        

        Bdd obj = new Bdd(getContext(),"listeCourse.db", null, 28);
        List<Prods> prods = obj.createProds();

        ListeCourseAdaptater adapter = new ListeCourseAdaptater(getContext(), prods);

       pUserListView.setAdapter(adapter);
        return vue;
    }

}
