package com.example.dtable.lurs2;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.content.Context;
import android.content.ContextWrapper;
import android.location.Address;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import junit.framework.TestCase;
import junit.framework.TestResult;

import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;
////////////////////Trash, moved to android test folder
//////////////////////////////////////////////////////////
@RunWith(MockitoJUnitRunner.class)
public class Near extends TestCase {

    @Mock
    NearbyFragment frag=new NearbyFragment();

    AppDatabase db;

    @Test
   public void test_db(){

        AppDatabase db=AppDatabase.INSTANCE;
        ReviewDao dbDao=db.getReviewDao();
        Handler dbHandler=new Handler(dbDao);
        dbHandler.delete();
        dbHandler.createDB();
        assert db==null;
    }


}
