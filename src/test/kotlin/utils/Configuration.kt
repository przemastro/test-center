package utils

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidElement
import io.appium.java_client.remote.MobileCapabilityType
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL
import java.time.LocalDateTime


object Configuration {
    @JvmField
    var ad: AndroidDriver<AndroidElement>? = null
    var driver: WebDriver? = null
    var datetime = LocalDateTime.now()

    fun setApiUrl(): String {
        return if(System.getProperty("apiUrl")!=null){
            println(System.getProperty("apiUrl"))
            System.getProperty("apiUrl")
        }
        else {
            val env = DataUtil.YAMLParse.parseProp("src/test/resources/functional-automated-tests.yaml", Device::class)
            return env.apiUrl
        }
    }

    /**
     * Setup device with desired capabilities.
     *
     */
    fun setupDevice() {
        val setupDevice = DataUtil.YAMLParse.parseProp("src/test/resources/functional-automated-tests.yaml", Device::class)
        if(System.getProperty("platformName")!=null){
            println(System.getProperty("platformName"))
            when (System.getProperty("localDevice")) {
                "True" ->
                    setCapabilitiesCI(System.getProperty("localDevice"),
                            System.getProperty("platformName"),
                            System.getProperty("localPlatformVersion"),
                            setupDevice.runName + " " + LocalDateTime.now(),
                            System.getProperty("user.dir") + setupDevice.localAppPath,
                            System.getProperty("localAppiumURL"))
                "False" ->
                    setCapabilitiesCI(System.getProperty("browserStackDeviceName"),
                            System.getProperty("platformName"),
                            System.getProperty("browserStackPlatformVersion"),
                            setupDevice.runName + " " + LocalDateTime.now(),
                            System.getProperty("browserStackAppPath"),
                            System.getProperty("browserStackAppiumURL"))
            }
        }
        else {
            when (setupDevice.localDevice) {
                "True" ->
                    setCapabilities(setupDevice.localDeviceName,
                            setupDevice.platformName,
                            setupDevice.localPlatformVersion,
                            setupDevice.runName + " " + LocalDateTime.now(),
                            System.getProperty("user.dir") + setupDevice.localAppPath,
                            setupDevice.localAppiumURL)
                "False" ->
                    setCapabilities(setupDevice.browserStackDeviceName,
                            setupDevice.platformName,
                            setupDevice.browserStackPlatformVersion,
                            setupDevice.runName + " " + LocalDateTime.now(),
                            setupDevice.browserStackAppPath,
                            setupDevice.browserStackAppiumURL)
            }
        }
    }

    /**
     * Sets desired capabilities and runs android driver.
     *
     * @param deviceName       Name of the device to be used.
     * @param platformName     System to be used.
     * @param platformVersion  Version of the system to be used.
     * @param runName          Name of the run.
     * @param appPath          Localization of the app to be installed on the device.
     * @param appiumUrl        Url of the appium to be used
     */
    fun setCapabilities(deviceName: String, platformName: String, platformVersion: String, runName: String, appPath: String, appiumUrl: String) {
        val caps = DesiredCapabilities()
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName)
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion)
        caps.setCapability("name", runName)
        val setupDevice = DataUtil.YAMLParse.parseProp("src/test/resources/functional-automated-tests.yaml", Device::class)
        when (setupDevice.newAppInstallation) {
            "True" -> caps.setCapability("app", appPath)
            "False" -> {
                caps.setCapability("appPackage", "app.Package");
                caps.setCapability("appActivity", "app.Activity")
            }
        }
        println("setup driver")
        ad = AndroidDriver<AndroidElement>(URL(appiumUrl), caps)
    }

    /**
     * Sets desired capabilities and runs android driver.
     *
     * @param deviceName       Name of the device to be used.
     * @param platformName     System to be used.
     * @param platformVersion  Version of the system to be used.
     * @param runName          Name of the run.
     * @param appPath          Localization of the app to be installed on the device.
     * @param appiumUrl        Url of the appium to be used
     */
    fun setCapabilitiesCI(deviceName: String, platformName: String, platformVersion: String, runName: String, appPath: String, appiumUrl: String) {
        val caps = DesiredCapabilities()
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName)
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion)
        caps.setCapability("name", runName)
        when (System.getProperty("newAppInstallation")) {
            "True" -> caps.setCapability("app", appPath)
            "False" -> {
                caps.setCapability("appPackage", "app.Package");
                caps.setCapability("appActivity", "app.Activity")
            }
        }
        println("setup driver")
        ad = AndroidDriver<AndroidElement>(URL(appiumUrl), caps)
    }

    fun setupChromeDriver(): WebDriver {
        WebDriverManager.chromedriver().setup()
        val options = ChromeOptions()
        options.setExperimentalOption("useAutomationExtension", false)
        options.addArguments("--disable-extensions")
        options.addArguments("--no-sandbox")
        options.addArguments("--disable-dev-shm-usage")
        options.addArguments("--remote-debugging-port=9222")
        options.addArguments("--headless")
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true)
        println("setup Chrome Driver")
        driver = ChromeDriver(options)
        return driver as ChromeDriver
    }

    fun setupFirefoxDriver(): WebDriver {
        WebDriverManager.firefoxdriver().setup()

        val options = FirefoxOptions()
        options.addArguments("--disable-extensions")
        options.addArguments("--no-sandbox")
        options.addArguments("--disable-dev-shm-usage")
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true)
        println("setup Firefox Driver")
        driver = FirefoxDriver(options)
        return driver as FirefoxDriver
    }

    fun setupDriver() {
        if(System.getProperty("browser")=="Chrome") {
            setupChromeDriver()
        }
        else if(System.getProperty("browser")=="Firefox"){
            setupFirefoxDriver()
        }
    }

}