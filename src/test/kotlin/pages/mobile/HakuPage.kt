package pages.mobile

import elements.mobile.HakuPageElements
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.testng.Assert

class HakuPage : HakuPageElements() {

    init {
        PageFactory.initElements(ad, this)
    }

    fun verifyTitle(title: String?) {
        Assert.assertEquals(wait.until(ExpectedConditions.elementToBeClickable(textViewSearchTitle)).text, title)
    }

    fun clickAsunnotLaheltaMapContainer() {
        wait.until(ExpectedConditions.elementToBeClickable(asunnotLaheltaMapContainerButton)).click()
    }

    fun verifyAlertIsPresent() {
        wait.until(ExpectedConditions.alertIsPresent())
    }
}