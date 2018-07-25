package dbClasses;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addItem(Item item);

    @Query("select * from Item")
    public List<Item> getAllItem();

    @Query("delete from Item where name= :itemName")
    void delete(String itemName);
}
