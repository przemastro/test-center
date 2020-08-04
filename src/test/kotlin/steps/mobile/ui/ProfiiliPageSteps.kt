package steps.mobile.ui

import pages.mobile.ProfiiliPage


class ProfiiliPageSteps {
    private val profiiliPage = ProfiiliPage()

    @io.cucumber.java.en.When("I click profiili {string} button")
    fun clickProfiiliButton(button: String?) {
        profiiliPage.clickButton(button)
    }

    @io.cucumber.java.en.When("I click CONTINUE on Terms and Privacy Policy page")
    fun clickContinueOnTermsAndPrivacyPolicyPage() {
        profiiliPage.clickContinueOnTermsAndPrivacyPolicyPage()
    }

    @io.cucumber.java.en.When("I type facebook email {string}")
    fun typeFacebookEmail(value: String?) {
        profiiliPage.typeFacebookEmail(value)
    }

    @io.cucumber.java.en.When("I type facebook password {string}")
    fun typeFacebookPassword(value: String?) {
        profiiliPage.typeFacebookPassword(value)
    }

    @io.cucumber.java.en.When("I click profiili {string} switch")
    fun clickProfiiliSwitch(button: String?) {
        profiiliPage.clickSwitch(button)
    }

    @io.cucumber.java.en.When("I click Kirjaudu tai luo tunnus button")
    fun clickKirjauduTaiLuoTunnusButton() {
        profiiliPage.clickKirjauduTaiLuoTunnusButton()
    }

    @io.cucumber.java.en.When("I click Vaihda salasana button")
    fun clickVaihdaSalasanaButton() {
        profiiliPage.clickVaihdaSalasanaButton()
    }

    @io.cucumber.java.en.Given("I verify {string} message appears on Profiili")
    fun verifyMessageOnProfiili(message: String?) {
        profiiliPage.verifyMessage(message)
    }

    @io.cucumber.java.en.When("I click Jatka button on Profiili page")
    fun clickJatkaButtonOnProfiiliPage() {
        profiiliPage.clickJatkaButtonOnProfiiliPage()
    }

    @io.cucumber.java.en.When("I verify profiili {string} button is disabled")
    fun verifyProfiiliButtonIsDisabled(button: String?) {
        profiiliPage.verifyButtonIsDisabled(button)
    }

    @io.cucumber.java.en.When("I type {string} into {string} field on Profiili")
    fun typeValueIntoFieldOnProfiili(value: String?, field: String?) {
        profiiliPage.typeValueIntoField(value, field)
    }

    @io.cucumber.java.en.When("I do not see profiili {string} button")
    fun verifyProfiiliButtonIsNotPresent(button: String?) {
        profiiliPage.verifyButtonIsNotPresent(button)
    }
}