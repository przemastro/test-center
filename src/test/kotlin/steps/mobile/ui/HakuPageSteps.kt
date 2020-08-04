package steps.mobile.ui

import pages.mobile.HakuPage


class HakuPageSteps {
    private val hakuPage = HakuPage()

    @io.cucumber.java.en.Then("I see {string} title on Haku")
    fun verifyTitleOnHaku(title: String?) {
        hakuPage.verifyTitle(title)
    }

    @io.cucumber.java.en.When("I click Asunnot lahelta map container")
    fun clickAsunnotLaheltaMapContainer() {
        hakuPage.clickAsunnotLaheltaMapContainer()
    }

    @io.cucumber.java.en.Given("I see alert window")
    fun verifyAlertIsPresent() {
        hakuPage.verifyAlertIsPresent()
    }
}