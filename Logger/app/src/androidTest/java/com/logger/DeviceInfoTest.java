package com.logger;


import android.content.Context;
import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;
import com.logger.device.DeviceInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class DeviceInfoTest {

    private Context appContext;
    private DeviceInfo deviceInfo;

    @Before
    public void init() throws Exception {
        appContext = InstrumentationRegistry.getTargetContext();
        deviceInfo = new DeviceInfo(appContext);
    }

    @Test
    public void shouldLoadAllTheDeviceParameters() {
        assertNotNull("Device OS Version", deviceInfo.getOsVersion());
        assertNotNull("Device Brand", deviceInfo.getDeviceBrand());
        assertNotNull("Device Manufacturer", deviceInfo.getDeviceManufacturer());
        assertNotNull("Device Model", deviceInfo.getDeviceModel());
        assertNotNull("AppName", deviceInfo.getAppName());
        assertNotNull("ApiLevel", deviceInfo.getApiLevel());
    }
}
