package steps

import io.appium.java_client.android.nativekey.AndroidKey.ENTER
import io.appium.java_client.android.nativekey.AndroidKey.PAGE_UP
import io.appium.java_client.android.nativekey.KeyEvent
import io.qameta.allure.Allure
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import utils.Configuration
import utils.Configuration.ad
import utils.Configuration.driver
import utils.DataUtil
import utils.Device
import java.io.InputStream
import java.net.MalformedURLException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.time.LocalDateTime
import java.util.*


open class MainTest {

    init {
        val setupDevice = DataUtil.YAMLParse.parseProp("src/test/resources/functional-automated-tests.yaml", Device::class)
        if(setupDevice.web == "True" || System.getProperty("web") == "True"){
            println("test")
            Configuration.setupDriver()
        }
        else {
            Configuration.setupDevice()
        }
    }

    @Throws(MalformedURLException::class)
    fun beforeClass() {

        val setupDevice = DataUtil.YAMLParse.parseProp("src/test/resources/functional-automated-tests.yaml", Device::class)
        if(setupDevice.web == "True" || System.getProperty("web") == "True") {
            println("Web App Tests")
        }
        else {
            println("Android App Tests")
            when (setupDevice.localDevice) {
                "True" -> ad?.startRecordingScreen()
            }
            val wait = WebDriverWait(ad, 20)
            when (setupDevice.newAppInstallation) {
                "True" -> {
                    wait.until(ExpectedConditions.elementToBeClickable(By.id("debug_network_endpoint"))).click()
                    sleep(1000)
                    ad!!.pressKey(KeyEvent(PAGE_UP))
                    ad!!.pressKey(KeyEvent(PAGE_UP))
                    ad!!.pressKey(KeyEvent(ENTER))
                }
                "False" -> println("Continue")
            }
            wait.until(ExpectedConditions.elementToBeClickable(By.id("button_continue"))).click()
            wait.until(ExpectedConditions.elementToBeClickable(By.id("button_skipLogin"))).click()
            wait.until(ExpectedConditions.elementToBeClickable(By.id("button_noThanks"))).click()
        }
    }

    fun afterClass() {
        val setupDevice = DataUtil.YAMLParse.parseProp("src/test/resources/functional-automated-tests.yaml", Device::class)
        if(setupDevice.web == "True" || System.getProperty("web") == "True") {
            println("stop driver")
            driver!!.quit()
        }
        else {
            when (setupDevice.localDevice) {
                "True" -> {
                    val base64String: String? = ad?.stopRecordingScreen()
                    val data: ByteArray = Base64.getDecoder().decode(base64String)
                    val destinationPath = "target/filename" + "_" + LocalDateTime.now() + ".mov"
                    val path: Path = Paths.get(destinationPath)
                    Files.write(path, data)
                    ad?.stopRecordingScreen()

                    val content = Paths.get(destinationPath)
                    val inputStream: InputStream = Files.newInputStream(content)
                    Allure.addAttachment("", inputStream)
                }
            }
            println("stop driver")
            ad!!.quit()
        }
    }

    private fun sleep(sec: Long) {
        try {
            Thread.sleep(sec)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}



