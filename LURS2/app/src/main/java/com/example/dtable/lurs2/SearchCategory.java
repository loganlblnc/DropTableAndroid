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
import java.util.regex.*;
import java.util.List;


public class SearchCategory extends Fragment {
    public TextView categoryTitle;
    public EditText searchInput;
    public Button searchButton;
    public TextView textView2;

    AppDatabase db;
    ReviewDao dbDao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.searchcategory, container, false);
        db=AppDatabase.getFileDatabase(getContext());
        dbDao=db.getReviewDao();


        categoryTitle = (TextView) view.findViewById(R.id.categoryTitle);
        textView2=(TextView)view.findViewById(R.id.textView2);
        searchInput = (EditText) view.findViewById(R.id.searchInput);
        searchButton = (Button) view.findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView2.setText(searchCat());
            }
        });



        return view;
    }
    public String searchCat(){
        List<Review> reviews=dbDao.getAll();
        String str="";
        for(Review r:reviews){
            if(r.Category.toLowerCase().equals(searchInput.getText().toString().toLowerCase()))
                str+=r.locationName+" \n";
        }
        if(str=="")str="No Results";
        return str;
    }
}
