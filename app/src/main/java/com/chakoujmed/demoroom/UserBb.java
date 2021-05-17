package com.chakoujmed.demoroom;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {User.class},version = 1)
public abstract class UserBb extends RoomDatabase {
        public abstract IGestionUtilisateurs getUserDao();

}
