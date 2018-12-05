package com.example.dtable.lurs2;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;


@RunWith(MockitoJUnitRunner.class)
public class TestCases {


     @Mock
     CreateFragment frag;

    AppDatabase db;
    ReviewDao dbdao;


     @Test
     public void getRevName(){
         db=Room.inMemoryDatabaseBuilder(frag.getContext(),AppDatabase.class).allowMainThreadQueries().build();
         when(frag.getReview()).thenReturn(new Review("test","test","test"));
         Review r=frag.getReview();
         assert r.locationName.equals("test");
     }
    @Test
    public void getRevAddress(){
        when(frag.getReview()).thenReturn(new Review("test","testAdd","test"));
        Review r=frag.getReview();
        assert r.Address.equals("testAdd");
    }
    @Test
    public void getRevCat(){
        when(frag.getReview()).thenReturn(new Review("test","test","testCat"));
        Review r=frag.getReview();
        assert r.Category.equals("testCat");
    }
    @Test
    public void AddressInt(){
        when(frag.getReview()).thenReturn(new Review("test","123 test","testCat"));
        Review r=frag.getReview();
        assert r.Address.equals("123 test");
    }



}
