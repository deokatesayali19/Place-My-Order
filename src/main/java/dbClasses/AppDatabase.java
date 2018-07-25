package dbClasses;

import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;

@Database(entities = {Item.class},version = 17,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase INSTANCE;

    public abstract ItemDao itemDao();

    public static AppDatabase getDatabase(Context context){
        if(INSTANCE==null){
            INSTANCE =Room.databaseBuilder(context,
                    AppDatabase.class, "itemdatabase")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return INSTANCE;

    }

    public void destryInstance(){
        INSTANCE=null;
    }


}
