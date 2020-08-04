package pages.mobile

import elements.mobile.SinullePageElements
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.testng.Assert

class SinullePage : SinullePageElements() {

    init {
        PageFactory.initElements(ad, this)
    }

    fun verifyTitle(title: String?) {
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOf(textViewIntroTop)).text, title)
    }

    fun verifyShareTitle(title: String?) {
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOf(semTitleDefault)).text, title)
    }

    fun verifyHeaderTitle(title: String?) {
        Assert.assertEquals(wait.until(ExpectedConditions.elementToBeClickable(textViewTitleTop)).text, title)
    }

    override fun clickFirstOffer() {
        wait.until(ExpectedConditions.elementToBeClickable(imageViewSpotContentBig)).click()
    }
}