package pages.mobile

import elements.mobile.TapahtumatPageElements
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.testng.Assert

class TapahtumatPage : TapahtumatPageElements() {

    init {
        PageFactory.initElements(ad, this)
    }

    fun verifyTitle(title: String?) {
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOf(textViewTitle)).text, title)
    }
}