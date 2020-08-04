package pages.mobile

import elements.mobile.AsunnotPageElements
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.testng.Assert


class AsunnotPage : AsunnotPageElements() {

    init {
        PageFactory.initElements(ad, this)
    }

    fun verifyTitle(title: String?) {
        Assert.assertEquals(toolbarTitleTextView?.text, title)
    }

    override fun verifyButtonName(button: String?) {
        Assert.assertEquals(wait.until(ExpectedConditions.elementToBeClickable(contactButton)).text, button)
    }

    override fun clickTab(button: String?) {
        val locator = buttons(button)
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click()
    }

    override fun clickButton(button: String?) {
        val locator = buttons(button)
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click()
    }

    override fun buttons(button: String?): WebElement? {
        val buttons = HashMap<String, WebElement?>()
        buttons["OTA YHTEYTTÄ"] = otaYhteyttaButton
        buttons["NAYTA HAKUTULOKSET"] = naytaHakutuloksetButton
        buttons["Kohteen tiedot"] = infoButton
        buttons["Hintatiedot"] = pricingButton
        buttons["Palvelut"] = servicesButton
        return buttons.get(button)
    }
}