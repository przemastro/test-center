package steps.mobile.ui

import cucumber.api.java.After
import cucumber.api.java.Before
import pages.mobile.CommonPage
import steps.MainTest
import java.net.MalformedURLException


class TestSteps : MainTest() {
    private val commonPage = CommonPage()

    @Before
    @Throws(MalformedURLException::class)
    fun beforeScenario() {
        beforeClass()
    }

    @After
    fun afterScenario() {
        afterClass()
    }

    @io.cucumber.java.en.When("I click {string} button")
    fun clickButton(button: String?) {
        commonPage.clickButton(button)
    }
}

