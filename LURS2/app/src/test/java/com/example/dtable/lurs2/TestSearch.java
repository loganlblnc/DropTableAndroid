package com.example.dtable.lurs2;
import android.content.Context;
import android.content.ContextWrapper;
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
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

@RunWith(MockitoJUnitRunner.class)
public class TestSearch {
    TextView createTitle;
    EditText category;
    EditText entry;
    EditText location;
    Button createButton;

    @Mock
    SearchCategory frag;
    @Test
    public void getEmpty(){
        when(frag.searchCat()).thenReturn("");
        String str=frag.searchCat();
        assert str.equals("");
    }
    @Test
    public void getChars(){
        when(frag.searchCat()).thenReturn("chars");
        String str=frag.searchCat();
        assert str.equals("chars");
    }
    @Test
    public void getSpace(){
        when(frag.searchCat()).thenReturn("chars chars");
        String str=frag.searchCat();
        assert str.equals("chars chars");
    }


}
