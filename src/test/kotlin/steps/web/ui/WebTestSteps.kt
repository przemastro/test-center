package steps.web.ui

import cucumber.api.java.After
import cucumber.api.java.Before
import pages.web.CommonWebPage
import steps.MainTest
import java.net.MalformedURLException

class WebTestSteps : MainTest() {
    private val commonWebPage = CommonWebPage()

    @Before
    @Throws(MalformedURLException::class)
    fun beforeScenario() {
        beforeClass()
    }

    @After
    fun afterScenario() {
        afterClass()
    }
}