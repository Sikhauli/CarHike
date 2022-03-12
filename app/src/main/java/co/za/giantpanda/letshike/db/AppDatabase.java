package co.za.giantpanda.letshike.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import co.za.giantpanda.letshike.db.entity.RegisterEntity;

@Database(entities = { RegisterEntity.class }, version = 1)
public abstract class AppDatabase extends RoomDatabase {

  public abstract AppDao appDao();

  private static AppDatabase INSTANCE;

  public static AppDatabase getDatabaseInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "MyChatApp")
          .allowMainThreadQueries()
          .build();
    }
    return INSTANCE;
  }
}
