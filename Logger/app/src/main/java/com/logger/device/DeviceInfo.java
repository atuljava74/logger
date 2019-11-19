package com.logger.device;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

public class DeviceInfo {

    String appVersion;
    String deviceBrand;
    String deviceManufacturer;
    String deviceModel;
    String appName;
    String osVersion;
    String apiLevel;

    public DeviceInfo(Context context) {
        setAppInfo(context);
    }

    private void setAppInfo(Context context) {
        deviceBrand = Build.BRAND;
        deviceManufacturer = Build.MANUFACTURER;
        deviceModel = Build.MODEL;
        osVersion = Build.VERSION.RELEASE;
        appName = getAppName(context);
        appVersion  = getAppVersion(context);
        apiLevel = String.format("%d", Build.VERSION.SDK_INT);
    }

    private String getAppVersion(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String name = context.getPackageName();
            PackageInfo info = packageManager.getPackageInfo(name, 0);
            return info.versionName;
        } catch (Exception e) {
            return "UNKNOWN";
        }
    }

    private String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            ApplicationInfo appInfo = packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA);
            return packageManager.getApplicationLabel(appInfo).toString();
        } catch (Exception e) {
            return "UNKNOWN";
        }
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public String getDeviceManufacturer() {
        return deviceManufacturer;
    }

    public void setDeviceManufacturer(String deviceManufacturer) {
        this.deviceManufacturer = deviceManufacturer;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getApiLevel() {
        return apiLevel;
    }

    public void setApiLevel(String apiLevel) {
        this.apiLevel = apiLevel;
    }
}
