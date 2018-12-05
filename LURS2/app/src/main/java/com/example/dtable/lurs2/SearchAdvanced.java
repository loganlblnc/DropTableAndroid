package com.example.dtable.lurs2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchAdvanced extends Fragment {
    private TextView advancedTitle;
    private EditText searchInput;
    private Button searchButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.searchadvanced, container, false);
        advancedTitle = (TextView) view.findViewById(R.id.advancedTitle);
        searchInput = (EditText) view.findViewById(R.id.searchInput);
        searchButton = (Button) view.findViewById(R.id.searchButton);
        

        return view;
    }
}
