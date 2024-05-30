package pages.web

import elements.web.ProfiiliWebPageElements
import org.openqa.selenium.support.PageFactory

class ExampleWebPage : ExampleWebPageElements() {

    init {
        PageFactory.initElements(driver, this)
    }

    fun navigateTo() {
        driver?.get("https://example")
    }

}