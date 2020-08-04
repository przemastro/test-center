package steps.mobile.ui

import pages.mobile.TyopaikatPage


class TyopaikatPageSteps {
    private val tyopaikatPage = TyopaikatPage()

    @io.cucumber.java.en.And("I see {string} title on Työpaikat page")
    fun verifyTitleOnTyopaikatPage(title: String?) {
        tyopaikatPage.verifyTitle(title)
    }
}