package steps.web.ui

import pages.web.ExampleWebPage


class ExampleWebPageSteps {

    private val exampleWebPage = ExampleWebPage()

    @io.cucumber.java.en.When("I navigate to")
    fun navigateTo() {
        profiiliWebPage.navigateTo()
    }
}