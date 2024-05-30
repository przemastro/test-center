package steps.mobile.ui

import pages.mobile.ExamplePage


class ExamplePageSteps {
    private val examplePage = ExamplePage()

    @io.cucumber.java.en.And("I see {string} title on Page")
    fun verifyTitleOnExamplePage(title: String?) {
        examplePage.verifyTitle(title)
    }
}