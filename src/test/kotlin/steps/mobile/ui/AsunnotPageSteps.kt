package steps.mobile.ui

import pages.mobile.AsunnotPage


class AsunnotPageSteps {
    private val asunnotPage = AsunnotPage()

    @io.cucumber.java.en.And("I see {string} title on Asunnot page")
    fun verifyTitleOnAsunnotPage(title: String?) {
        asunnotPage.verifyTitle(title)
    }

    @io.cucumber.java.en.When("I click asunnot {string} button")
    fun clickAsunnotButton(button: String?) {
        asunnotPage.clickButton(button)
    }

    @io.cucumber.java.en.Given("I see {string} button on Asunnot")
    fun verifyAsunnotButtonName(button: String?) {
        asunnotPage.verifyButtonName(button)
    }

    @io.cucumber.java.en.When("I click {string} tab on Asunnot")
    fun clickAsunnotTab(button: String?) {
        asunnotPage.clickTab(button)
    }
}