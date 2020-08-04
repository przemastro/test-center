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

    @io.cucumber.java.en.When("I click {string} switch")
    fun clickSwitch(button: String?) {
        commonPage.clickSwitch(button)
    }

    @io.cucumber.java.en.When("I click X button")
    fun clickXButton() {
        commonPage.clickReturnButton()
    }

    @io.cucumber.java.en.When("I click pop up {string} button")
    fun clickPopUpButton(button: String?) {
        commonPage.clickPopUpButton(button)
    }

    @io.cucumber.java.en.When("I click favourite icon")
    fun clickFavouriteIcon() {
        commonPage.clickFavouriteIcon()
    }

    @io.cucumber.java.en.When("I click bottom tab {string} button")
    fun clickBottomTabButton(button: String?) {
        commonPage.clickBottomTabButton(button)
    }

    @io.cucumber.java.en.When("I click phone {string} button")
    fun clickPhoneBackButton(button: String?) {
        commonPage.clickPhoneBackButton(button)
    }

    @io.cucumber.java.en.Then("I go back to previous page")
    fun goBackToPreviousPage() {
        commonPage.clickReturnButton()
    }

    @io.cucumber.java.en.Given("I see {string} screen")
    fun verifyScreenTitle(title: String?) {
        commonPage.verifyScreenTitle(title)
    }

    @io.cucumber.java.en.When("I click on share symbol on the top right")
    fun clickShareIcon() {
        commonPage.clickShareIcon()
    }

    @io.cucumber.java.en.And("I click first offer")
    fun clickFirstOffer() {
        commonPage.clickFirstOffer()
    }

    @io.cucumber.java.en.When("I click favourite icon on the top right")
    fun clickFavIconTR() {
        commonPage.clickFavIconTR()
    }

    @io.cucumber.java.en.When("I click popup {string} button")
    fun clickPopupButton(button: String?) {
        commonPage.clickPopupButton(button)
    }

    @io.cucumber.java.en.Given("I see {string} button")
    fun verifyButtonName(button: String?) {
        commonPage.verifyButtonName(button)
    }

    @io.cucumber.java.en.When("I click {string} tab")
    fun clickTab(button: String?) {
        commonPage.clickTab(button)
    }

    @io.cucumber.java.en.When("I scroll to the top of the page")
    fun clickScrollUpButton() {
        commonPage.clickScrollUpButton()
    }

    @io.cucumber.java.en.And("I see {string} title on Ota Yhteytta page")
    fun verifyTitleOnOtaYhteytta(title: String?) {
        commonPage.verifyTitleOnOtaYhteytta(title)
    }

    @io.cucumber.java.en.When("I click laheta viesti icon button")
    fun clickLahetaViestiIcon() {
        commonPage.clickLahetaViestiIcon()
    }

    @io.cucumber.java.en.Given("I see {string} title on Laheta Viesti")
    fun verifyTitleOnLahetaViesti(title: String?) {
        commonPage.verifyTitleOnLahetaViesti(title)
    }

    @io.cucumber.java.en.Given("I verify {string} message appears")
    fun verifyMessage(message: String?) {
        commonPage.verifyMessage(message)
    }

    @io.cucumber.java.en.When("I click return button")
    fun clickReturnIcon() {
        commonPage.clickReturnButton()
    }

    @io.cucumber.java.en.When("I verify {string} button is disabled")
    fun verifyButtonIsDisabled(button: String?) {
        commonPage.verifyButtonIsDisabled(button)
    }

    @io.cucumber.java.en.When("I type {string} into {string} field")
    fun typeValueIntoField(value: String?, field: String?) {
        commonPage.typeValueIntoField(value, field)
    }

    @io.cucumber.java.en.When("I do not see {string} button")
    fun verifyButtonIsNotPresent(button: String?) {
        commonPage.verifyButtonIsNotPresent(button)
    }
}

