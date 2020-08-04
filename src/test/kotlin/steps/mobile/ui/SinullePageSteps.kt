package steps.mobile.ui

import pages.mobile.SinullePage


class SinullePageSteps {
    private val sinullePage = SinullePage()

    @io.cucumber.java.en.Given("I see {string} title on Sinulle")
    fun verifyTitleOnSinulle(title: String?) {
        sinullePage.verifyTitle(title)
    }

    @io.cucumber.java.en.Given("I see share {string} title")
    fun verifyShareTitle(title: String?) {
        sinullePage.verifyShareTitle(title)
    }

    @io.cucumber.java.en.Given("I see {string} header on Sinulle")
    fun verifyHeaderOnSinulle(title: String?) {
        sinullePage.verifyHeaderTitle(title)
    }

    @io.cucumber.java.en.And("I click first offer on Sinulle")
    fun clickFirstOfferOnSinulle() {
        sinullePage.clickFirstOffer()
    }
}