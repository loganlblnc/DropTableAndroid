package com.example.dtable.lurs2;


import android.app.Activity;
import android.app.ActivityManager;
import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.CloseKeyboardAction;
import android.support.test.espresso.action.TypeTextAction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(AndroidJUnit4.class)
public class IntTest {
    @Rule
    public InstantTaskExecutorRule icer =new InstantTaskExecutorRule();


    AppDatabase db;
    ReviewDao dbdao;

    @Before
    public void initDB() throws Exception{
        db=Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),AppDatabase.class).allowMainThreadQueries()
                .build();
        dbdao=db.getReviewDao();
    }
    @After
    public  void closedb(){
        db.close();
    }


    @Test
    public void testingEmptyDB(){
        List<Review> reviews=dbdao.getAll();
        Assert.assertTrue(reviews.isEmpty());
    }

    @Test
    public void insert(){
        Review r=new Review("test","test","test");
        dbdao.insertAll(r);
        List<Review> reviews=dbdao.getAll();
        Assert.assertTrue(!reviews.isEmpty());
    }

    @Test
    public void checkName(){
        Review r=new Review("test","test","test");
        dbdao.insertAll(r);
        List<Review> reviews=dbdao.getAll();
        Assert.assertTrue(reviews.get(0).locationName.equals("test"));
    }
    @Test
    public void checkAddress(){
        Review r=new Review("test","add","test");
        dbdao.insertAll(r);
        List<Review> reviews=dbdao.getAll();
        Assert.assertTrue(reviews.get(0).Address.equals("add"));
    }
    @Test
    public void checkCategory(){
        Review r=new Review("test","test","cat");
        dbdao.insertAll(r);
        List<Review> reviews=dbdao.getAll();
        Assert.assertTrue(reviews.get(0).Category.equals("cat"));
    }



}
