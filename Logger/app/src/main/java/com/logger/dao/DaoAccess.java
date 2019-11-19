package com.logger.dao;

import androidx.room.*;
import com.logger.model.Logs;

@Dao
public interface DaoAccess {

    @Insert
    Long insertLog(Logs log);

    @Query("SELECT * FROM Logs ORDER BY id asc limit 1")
    Logs fetchLog();

    @Delete
    void deleteLog(Logs note);

    @Query("select count(*) as total from Logs")
    int getTotalLogs();
}
