package pages.web

import elements.web.ProfiiliWebPageElements
import org.openqa.selenium.support.PageFactory

class ProfiiliWebPage : ProfiiliWebPageElements() {

    init {
        PageFactory.initElements(driver, this)
    }

    fun navigateTo() {
        driver?.get("https://oikotie.fi")
    }

}