package co.za.giantpanda.letshike.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import co.za.giantpanda.letshike.db.entity.RegisterEntity;
import java.util.List;

@Dao
public interface AppDao {

  @Query("SELECT phone_number FROM Register_users_table")
  LiveData<List<RegisterEntity>> fetchPhoneNUmber();

  @Insert
  void insertUserDetail(RegisterEntity registerEntity);
}
