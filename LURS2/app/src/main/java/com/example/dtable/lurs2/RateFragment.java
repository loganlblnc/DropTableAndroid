package com.example.dtable.lurs2;

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
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;

public class RateFragment extends Fragment {
    private TextView rateTitle;
    private TextView item;
    private TextView location;
    private TextView category;
    private RatingBar ratingBar;
    Button getButton;
    private EditText search;
    EditText review;
    Button setReview;

    AppDatabase db;
    ReviewDao dbdao;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rate, container, false);
        rateTitle = (TextView) view.findViewById(R.id.rateTitle);
        item = (TextView) view.findViewById(R.id.item);
        location = (TextView) view.findViewById(R.id.location);
        category = (TextView) view.findViewById(R.id.category);
        ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        search=(EditText)view.findViewById(R.id.search);
        getButton=(Button)view.findViewById(R.id.getItem);
        review=(EditText)view.findViewById(R.id.Review);
        setReview=(Button)view.findViewById(R.id.Rate);



        db=AppDatabase.getFileDatabase(getContext());
        dbdao=db.getReviewDao();

        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<Review> reviews=reviews=dbdao.getWithName(search.getText().toString());
                if (reviews.isEmpty()){
                    //No Item Found
                    item.setText("None Found");
                    location.setText("NA");
                    category.setText("NA");
                }
                else {
                    item.setText(reviews.get(0).locationName);
                    location.setText(reviews.get(0).Address);
                    category.setText(reviews.get(0).Category);
                }

            }
        });
        setReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(item.getText().equals("None Found")){
                    //No object to rate
                }
                else {
                    //Rate
                    List<Review> reviews=reviews=dbdao.getWithName(search.getText().toString());
                    Review r =reviews.get(0);
                    r.Rating=ratingBar.getRating();
                    r.Reviews=review.getText().toString();
                    dbdao.updateItem(r);
                }
                }
            }
        );



        return view;
    }
}
