package com.logger.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.logger.dao.DaoAccess;
import com.logger.model.Logs;


@Database(entities = {Logs.class}, version = 1, exportSchema = false)
public abstract class LogDatabase extends RoomDatabase {

    public abstract DaoAccess daoAccess();
}
