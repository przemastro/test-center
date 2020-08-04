package pages.mobile

import elements.mobile.CommonPageElements
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidElement
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.Assert
import utils.Configuration


open class CommonPage : CommonPageElements() {
    @JvmField
    protected var ad: AndroidDriver<AndroidElement> = Configuration.ad!!

    var explicitWait: Long = 10
    var wait: WebDriverWait

    init {
        PageFactory.initElements(ad, this)
        wait = WebDriverWait(ad, explicitWait)
    }

    open fun clickButton(button: String?) {
        val locator = buttons(button)
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click()
    }

    fun clickBottomTabButton(button: String?) {
        val locator = buttons(button)
        wait.until(ExpectedConditions.visibilityOf(locator)).click()
    }

    fun clickPopUpButton(button: String?) {
        val locator = buttons(button)
        sleep(1000)
        locator!!.click()
        //ad.findElements(MobileElement(locator)).get(0).click()
    }

    open fun buttons(button: String?): WebElement? {
        val buttons = HashMap<String, WebElement?>()
        buttons["ASUNNOT"] = asunnotButton
        buttons["Haku"] = hakuButton
        buttons["Sinulle"] = sinulleButton
        buttons["Tapahtumat"] = tapahtumatButton
        buttons["Profiili"] = profiiliButton
        buttons["TYÖPAIKAT"] = tyopaikatButton
        buttons["EI"] = eiButton
        buttons["KYLLÄ"] = kyllaButton
        buttons["Ei Kiitos"] = eiKiitosButton
        buttons["Tallenna"] = tallennaButton
        buttons["Kohteen tiedot"] = kohteenTiedotButton
        buttons["LAHETA VIESTI"] = lahetaViestiButton
        buttons["PERUUTA"] = peruutaButton
        buttons["KIRJAUDO ULOS"] = kirjaudoUlosButton
        buttons["Kirjaudu Facebook-tunnuksilla"] = kirjauduFacebookTunnuksillaButton
        buttons["Kirjaudu tai luo tunnus"] = kirjauduTaiLuoTunnus
        //buttons["Tallennetut"] = tallennetutButton
        return buttons.get(button)
    }

    open fun switches(button: String?): WebElement? {
        val switches = HashMap<String, WebElement?>()
        return switches.get(button)
    }

    open fun messages(button: String?): WebElement? {
        val messages = HashMap<String, WebElement?>()
        return messages.get(button)
    }

    fun clickReturnButton() {
        wait.until(ExpectedConditions.elementToBeClickable(returnButton)).click()
    }

    fun clickPhoneBackButton(button: String?) {
        sleep(2000)
        when (button) {
            "Back" -> ad!!.pressKey(KeyEvent(AndroidKey.BACK))
            else -> {
                print("Nothing on my list")
            }
        }
    }

    fun clickFavouriteIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(favouriteIcon)).click()
    }

    fun verifyScreenTitle(title: String?) {
        Assert.assertEquals(wait.until(ExpectedConditions.elementToBeClickable(screenTitle)).text, title)
    }

    fun clickShareIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(shareIcon)).click()
        sleep(2000)
    }

    fun clickFavIconTR() {
        wait.until(ExpectedConditions.elementToBeClickable(favIconTR)).click()
    }

    open fun clickFirstOffer() {
        wait.until(ExpectedConditions.elementToBeClickable(imageViewButton)).click()
    }

    fun clickPopupButton(button: String?) {
        sleep(2000)
        val locator = buttons(button)
        locator!!.click()
        //ad.findElements(MobileElement(locator)).get(0).click()
    }

    open fun verifyButtonName(button: String?) {
    }

    open fun clickTab(button: String?) {
    }

    fun clickScrollUpButton() {
        wait.until(ExpectedConditions.elementToBeClickable(scrollUpButton)).click()
    }

    fun verifyTitleOnOtaYhteytta(title: String?) {
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOf(titleOnOtaYhteytta)).text, title)
    }

    fun clickLahetaViestiIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(lahetaViestiIcon)).click()
    }

    fun verifyTitleOnLahetaViesti(title: String?) {
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOf(titleOnLahetaViesti)).text, title)
    }

    open fun verifyButtonIsDisabled(button: String?) {
        val locator = buttons(button)
        val isEnabled = locator!!.isEnabled
        Assert.assertFalse(isEnabled)
    }

    open fun inputFields(field: String?): WebElement? {
        val fields = HashMap<String, WebElement?>()
        fields["Email"] = emailInputField
        return fields.get(field)
    }

    open fun typeValueIntoField(value: String?, field: String?) {
        val locator = inputFields(field)
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click()
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(value)
        ad.pressKey(KeyEvent(AndroidKey.A))
        ad.pressKey(KeyEvent(AndroidKey.DEL))
    }

    open fun verifyButtonIsNotPresent(button: String?) {
        val locator = buttons(button)
        wait.until(ExpectedConditions.invisibilityOf(locator))
    }

    open fun clickSwitch(button: String?) {
        val locator = switches(button)
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click()
    }

    open fun verifyMessage(message: String?) {
        val locator = messages(message)
        Assert.assertEquals(wait.until(ExpectedConditions.elementToBeClickable(locator)).text, message)
    }

    fun sleep(sec: Long) {
        try {
            Thread.sleep(sec)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

}
