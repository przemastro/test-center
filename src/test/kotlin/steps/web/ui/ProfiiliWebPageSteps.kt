package steps.web.ui

import pages.web.ProfiiliWebPage


class ProfiiliWebPageSteps {

    private val profiiliWebPage = ProfiiliWebPage()

    @io.cucumber.java.en.When("I navigate to")
    fun navigateTo() {
        println("test")
        profiiliWebPage.navigateTo()
    }
}