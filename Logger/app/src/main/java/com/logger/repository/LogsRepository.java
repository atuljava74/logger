package com.logger.repository;

import android.content.Context;
import android.os.AsyncTask;
import androidx.room.Room;
import com.google.gson.Gson;
import com.logger.db.LogDatabase;
import com.logger.device.DeviceInfo;
import com.logger.model.Logs;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;


public class LogsRepository {

    private static String DB_NAME = "gap_logs";
    private static LogDatabase logDatabase;
    private static Gson gson;
    private static String deviceInfoJson;
    private static LogsRepository logsRepository;

    private LogsRepository(){

    }

    public static void init(Context context){
        logDatabase = Room.databaseBuilder(context, LogDatabase.class, DB_NAME).build();
        logsRepository = new LogsRepository();
        gson = new Gson();
        deviceInfoJson = gson.toJson(new DeviceInfo(context));
    }

    public static LogsRepository getInstance() {
        return logsRepository;
    }

    public void insertLog(String data) {
        Logs log = new Logs();
        log.setData(data);
        log.setTimeOfLog(new Date().getTime());
        insertLog(log);
    }

    public void insertLog(final Logs log) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                logDatabase.daoAccess().insertLog(log);
                return null;
            }
        }.execute();
    }

    public void deleteLog(final Logs log) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                logDatabase.daoAccess().deleteLog(log);
                return null;
            }
        }.execute();
    }

    public Logs getLog() {
        return logDatabase.daoAccess().fetchLog();
    }

    public int getTotalLogs(){
        return logDatabase.daoAccess().getTotalLogs();
    }

    String getLogJsonWithDeviceInfo(Logs log){
        String logJson = gson.toJson(log);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("log",logJson);
            jsonObject.put("deviceInfo", deviceInfoJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String logForQueue = jsonObject.toString();
        return logForQueue;
    }
}
