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

import java.util.List;

public class SearchObject extends Fragment {
    private TextView objectTitle;
    private EditText searchInput;
    private Button searchButton;
    private TextView display;


    AppDatabase db;
    ReviewDao dbDao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.searchobject, container, false);
        objectTitle = (TextView) view.findViewById(R.id.objectTitle);
        searchInput = (EditText) view.findViewById(R.id.searchInput);
        searchButton = (Button) view.findViewById(R.id.searchButton);
        display=(TextView)view.findViewById(R.id.display);

        db=AppDatabase.getFileDatabase(getContext());
        dbDao=db.getReviewDao();

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Review> reviews=dbDao.getAll();
                String str="";
                for(Review r:reviews){
                    if(r.locationName.toLowerCase().contains(searchInput.getText().toString().toLowerCase()))
                        str+=r.locationName+" \n";
                }
                if(str=="")str="No Results";
                display.setText(str);
            }
        });

        return view;
    }
}
