package steps.mobile.ui

import pages.mobile.TapahtumatPage


class TapahtumatPageSteps {
    private val tapahtumatPage = TapahtumatPage()

    @io.cucumber.java.en.And("I see {string} title on Tapahtumat page")
    fun verifyTitleOnTapahtumatPage(title: String?) {
        tapahtumatPage.verifyTitle(title)
    }
}