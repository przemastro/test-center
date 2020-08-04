package pages.web

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.WebDriverWait


open class CommonWebPage {
    @JvmField
    protected var driver: WebDriver = utils.Configuration.driver!!

    var explicitWait: Long = 10
    var wait: WebDriverWait


    init {
        PageFactory.initElements(driver, this)
        wait = WebDriverWait(driver, explicitWait)
    }

    fun sleep(sec: Long) {
        try {
            Thread.sleep(sec)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

}
