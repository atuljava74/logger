package com.logger;

import android.content.Context;
import android.util.Log;
import com.logger.model.Logs;
import com.logger.repository.LogsRepository;

public class GapLogger {

    private static String repoUrl;
    private static Context context;
    private static boolean verbose;

    public static String getRepoUrl() {
        return repoUrl;
    }

    public static void setRepoUrl(String repoUrl) {
        GapLogger.repoUrl = repoUrl;
    }

    public static boolean isVerbose() {
        return verbose;
    }

    public static void setVerbose(boolean verbose) {
        GapLogger.verbose = verbose;
    }

    public static void initialize(Context appContext, String url) {
        repoUrl = url;
        context = appContext;
    }

    void log(String logData){
        if(context == null){
            Log.d("GapLogger","Please initialize before using logger");
            return;
        }
        if(LogsRepository.getInstance() == null){
            LogsRepository.init(context);
        }
        LogsRepository.getInstance().insertLog(logData);
    }

}