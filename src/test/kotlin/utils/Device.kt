package utils

data class Device(
        val localDevice: String,
        val newAppInstallation: String,
        val localDeviceName: String,
        val platformName: String,
        val localPlatformVersion: String,
        val localAppPath: String,
        val localAppiumURL: String,
        val browserStackDeviceName: String,
        val browserStackPlatformVersion: String,
        val runName: String,
        val browserStackAppPath: String,
        val browserStackAppiumURL: String,
        val apiUrl: String,
        val web: String,
        val webUrl: String
)