package com.example.dtable.lurs2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class CreateFragment extends Fragment {
    private TextView createTitle;
     EditText category;
    private EditText entry;
    private EditText location;
    private Button createButton;
    AppDatabase db;
    ReviewDao dbDao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

        db=AppDatabase.getFileDatabase(getContext());
        dbDao=db.getReviewDao();


        final View view = inflater.inflate(R.layout.fragment_create, container, false);
        createTitle = (TextView) view.findViewById(R.id.createTitle);
        category = (EditText) view.findViewById(R.id.category);
        entry = (EditText) view.findViewById(R.id.entry);
        location = (EditText) view.findViewById(R.id.location);
        createButton = (Button) view.findViewById(R.id.createButton);


        createButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Review review=getReview();
                dbDao.insertAll(review);

            }

            public void OnClick(View v){}

        });




        return view;
    }
    public Review getReview(){
        String cat=category.getText().toString();
        String name=entry.getText().toString();
        String address=location.getText().toString();
        Review review=new Review(name,address,cat);
        return review;
    }

}
