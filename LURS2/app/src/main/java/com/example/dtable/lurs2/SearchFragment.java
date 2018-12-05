package com.example.dtable.lurs2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SearchFragment extends Fragment {
    private Button category;
    private Button location;
    private Button object;
    private Button advanced;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        category = (Button) view.findViewById(R.id.category);
        location = (Button) view.findViewById(R.id.location);
        object = (Button) view.findViewById(R.id.object);
        advanced = (Button) view.findViewById(R.id.advanced);

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FragmentsRecord.searchcategory == null)
                    FragmentsRecord.searchcategory = new SearchCategory();
                FragmentManager fragmentManager =
                        getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =
                        fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,
                        FragmentsRecord.searchcategory);
                //fragmentTransaction.addToBackStack(null);
                //fragmentTransaction.remove(this);
                fragmentTransaction.commit();
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FragmentsRecord.searchlocation == null)
                    FragmentsRecord.searchlocation = new SearchLocation();
                FragmentManager fragmentManager =
                        getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =
                        fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,
                        FragmentsRecord.searchlocation);
                //fragmentTransaction.addToBackStack(null);
                //fragmentTransaction.remove(this);
                fragmentTransaction.commit();
            }
        });

        object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FragmentsRecord.searchobject == null)
                    FragmentsRecord.searchobject = new SearchObject();
                FragmentManager fragmentManager =
                        getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =
                        fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,
                        FragmentsRecord.searchobject);
                //fragmentTransaction.addToBackStack(null);
                //fragmentTransaction.remove(this);
                fragmentTransaction.commit();
            }
        });

        advanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FragmentsRecord.searchadvanced == null)
                    FragmentsRecord.searchadvanced = new SearchAdvanced();
                FragmentManager fragmentManager =
                        getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =
                        fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,
                        FragmentsRecord.searchadvanced);
                //fragmentTransaction.addToBackStack(null);
                //fragmentTransaction.remove(this);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
