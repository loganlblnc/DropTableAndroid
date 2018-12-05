package com.example.dtable.lurs2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;

public class NearbyFragment extends Fragment {

    AppDatabase db;
    ReviewDao dbDao;
    TextView display;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nearby, container, false);
        display=(TextView)view.findViewById(R.id.display);




        db=makeDB();
        dbDao=db.getReviewDao();
        //Handler dbHandler=new Handler(dbDao);
        //dbHandler.delete();
        //dbHandler.createDB();
        String str="";
        List<Review> nearby=dbDao.getAll();
        for(Review r : nearby){
            str=str+"Location: "+r.locationName+"\n,Address "+r.Address+"\n,Category: "+r.Category+"\n";
            if(r.Reviews!=null){
                str+=" Review:"+r.Reviews+"\n";
            }
            if(r.Rating==0){
                str+="Rating: n/a\n";
            }
            else if(r.Rating!=0){
                str+="Rating: "+r.Rating+"\n";
            }
            str+="\n";
        }

        display.setText(str.toString());
        return view;
    }
    public AppDatabase makeDB(){
        AppDatabase data=AppDatabase.getFileDatabase(getContext());
        return data;
    }

}
