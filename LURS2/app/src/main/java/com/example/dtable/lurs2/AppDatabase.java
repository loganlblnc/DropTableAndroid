package com.example.dtable.lurs2;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Review.class},version = 2)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase INSTANCE;

    public abstract ReviewDao getReviewDao();
    public static AppDatabase getFileDatabase(Context context){
        if(INSTANCE==null){
            //INSTANCE=Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"database=filename").fallbackToDestructiveMigration()
              //      .allowMainThreadQueries().build();
            INSTANCE=Room.inMemoryDatabaseBuilder(context.getApplicationContext(),AppDatabase.class).allowMainThreadQueries().build();
        }

        return INSTANCE;
    }
    public static void destroyInstance(){INSTANCE=null;}
}
