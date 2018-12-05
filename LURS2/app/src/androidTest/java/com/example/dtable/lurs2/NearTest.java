package com.example.dtable.lurs2;


import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.when;

//Cant Do RunWithMockito and android IE @RunWith(MockitoUnitTest.class)
@RunWith(AndroidJUnit4.class)
public class NearTest {
    @Rule
    public InstantTaskExecutorRule icer =new InstantTaskExecutorRule();

    AppDatabase db;
    ReviewDao dbdao;
    @Rule
    public ActivityTestRule<MainActivity> mActivity=new ActivityTestRule<>(MainActivity.class);


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

    @Mock
    CreateFragment frag;

    @Test
    public void test_CreateFrag(){
        when(frag.getReview()).thenReturn(new Review("testName","testAdd","testCat"));
        Review r=frag.getReview();
        dbdao.insertAll(r);
        List<Review> reviews=dbdao.getAll();
        Assert.assertTrue(reviews.get(0).locationName.equals("testName"));
    }


}
