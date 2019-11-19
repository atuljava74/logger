package com.logger.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;


@Entity
public class Logs implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String data;
    private long timeOfLog;

    public long getTimeOfLog() {
        return timeOfLog;
    }

    public void setTimeOfLog(long timeOfLog) {
        this.timeOfLog = timeOfLog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
