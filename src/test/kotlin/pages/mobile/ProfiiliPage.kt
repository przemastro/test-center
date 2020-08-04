package pages.mobile

import elements.mobile.ProfiiliPageElements
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.testng.Assert

class ProfiiliPage : ProfiiliPageElements() {

    init {
        PageFactory.initElements(ad, this)
    }

    fun clickKirjauduTaiLuoTunnusButton() {
        wait.until(ExpectedConditions.elementToBeClickable(kirjauduTaiLuoTunnusButton)).click()
    }

    fun clickVaihdaSalasanaButton() {
        wait.until(ExpectedConditions.elementToBeClickable(vaihdaSalasanaButton)).click()
    }

    fun clickJatkaButtonOnProfiiliPage() {
        wait.until(ExpectedConditions.elementToBeClickable(jatkaButtonOnProfiiliPage)).click()
    }

    fun clickContinueOnTermsAndPrivacyPolicyPage() {
        wait.until(ExpectedConditions.elementToBeClickable(continueOnTermsAndPrivacyPolicyPageButton)).click()
    }

    fun typeFacebookEmail(value: String?) {
        wait.until(ExpectedConditions.elementToBeClickable(facebookEmailField)).sendKeys(value)
    }

    fun typeFacebookPassword(value: String?) {
        wait.until(ExpectedConditions.elementToBeClickable(facebookPasswordField)).sendKeys(value)
    }

    override fun clickButton(button: String?) {
        val locator = buttons(button)
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click()
    }

    override fun typeValueIntoField(value: String?, field: String?) {
        val locator = inputFields(field)
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click()
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(value)
        ad.pressKey(KeyEvent(AndroidKey.A))
        ad.pressKey(KeyEvent(AndroidKey.DEL))
    }

    override fun clickSwitch(button: String?) {
        val locator = switches(button)
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click()
    }

    override fun verifyButtonIsDisabled(button: String?) {
        val locator = buttons(button)
        val isEnabled = locator!!.isEnabled
        Assert.assertFalse(isEnabled)
    }

    override fun verifyMessage(message: String?) {
        val locator = messages(message)
        Assert.assertEquals(wait.until(ExpectedConditions.elementToBeClickable(locator)).text, message)
    }

    override fun verifyButtonIsNotPresent(button: String?) {
        val locator = ad.findElements(By.id("fi.oikotie.internal:id/menu_settings"))
        if (locator.size > 0) {
            Assert.assertFalse(true)
        }
        else {
            Assert.assertTrue(true)
        }
    }

    override fun buttons(button: String?): WebElement? {
        val buttons = HashMap<String, WebElement?>()
        buttons["Luo uusi Oikotie-tunnus"] = luoUusiOikotieTunnusButton
        buttons["Kirjaudu Oikotie-tunnuksilla"] = kirjauduOikotieTunnuksillaButton
        buttons["clear email"] = clearEmailButton
        buttons["Continue"] = continueButton
        buttons["Jatka"] = jatkaButton
        buttons["menu settings"] = menuSettingsButton
        buttons["logout"] = logoutButton
        buttons["Sulje"] = suljeButton
        return buttons.get(button)
    }

    override fun inputFields(field: String?): WebElement? {
        val fields = HashMap<String, WebElement?>()
        fields["email"] = emailField
        fields["password"] = passwordField
        fields["Existing Password"] = existingPasswordField
        fields["New Password"] = newPasswordField
        fields["Repeat Password"] = repeatPasswordField
        return fields.get(field)
    }

    override fun switches(button: String?): WebElement? {
        val switches = HashMap<String, WebElement?>()
        switches["Hyvaksyn Oikotien kayttoehdot ja tietosuojalausekkeen"] = hyvaksynOikotienKayttoehdotJaTietosuojalausekkeenSwitch
        return switches.get(button)
    }

    override fun messages(button: String?): WebElement? {
        val messages = HashMap<String, WebElement?>()
        messages["Sähköpostiosoite on jo rekisteröity"] = sahkopostiosoiteOnJoRekisteroity
        return messages.get(button)
    }
}