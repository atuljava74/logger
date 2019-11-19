package com.logger

import android.content.Context
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.logger.model.Logs
import com.logger.repository.LogsRepository

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before



@RunWith(AndroidJUnit4::class)
class DBTest {

    private var appContext: Context? = null

    @Before
    fun init() {
        appContext = InstrumentationRegistry.getTargetContext()
        LogsRepository.init(appContext)
    }

    @Test
    fun addLog() {

        var count = LogsRepository.getInstance().getTotalLogs();
        LogsRepository.getInstance().insertLog("First Log");
        Thread.sleep(2000);
        var newcount = LogsRepository.getInstance().getTotalLogs();
        assertEquals(newcount,count+1);
    }

    @Test
    fun deleteLog() {

        var count = LogsRepository.getInstance().getTotalLogs();
        LogsRepository.getInstance().deleteLog(LogsRepository.getInstance().getLog());
        Thread.sleep(2000);
        var newcount = LogsRepository.getInstance().getTotalLogs();
        assertEquals(newcount,count-1);
    }

    @Test
    fun dataAccuracy() {
        LogsRepository.getInstance().insertLog("Data Accuracy Test");
        Thread.sleep(2000);
        assertEquals(LogsRepository.getInstance().getLog().data, "Data Accuracy Test");
    }

}
