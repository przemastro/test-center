package elements.mobile

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import pages.mobile.CommonPage


open class ProfiiliPageElements : CommonPage() {

    @FindBy(xpath = "//*[contains(@text, 'Kirjaudu tai luo tunnus')]")
    var kirjauduTaiLuoTunnusButton: WebElement? = null

    @FindBy(xpath = "//*[contains(@text, 'Vaihda salasana')]")
    var vaihdaSalasanaButton: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/button")
    var jatkaButtonOnProfiiliPage: WebElement? = null

    @FindBy(xpath = "//*[contains(@text, 'CONTINUE')]")
    var continueOnTermsAndPrivacyPolicyPageButton: WebElement? = null

    @FindBy(xpath = "//android.widget.EditText[@Content-desc='Username']")
    var facebookEmailField: WebElement? = null

    @FindBy(xpath = "//android.widget.EditText[@Content-desc='Password']")
    var facebookPasswordField: WebElement? = null

    @FindBy(xpath = "//android.view.ViewGroup[contains(@resource-id, 'fi.oikotie.internal:id/container')]/android.widget.EditText")
    var emailField: WebElement? = null

    @FindBy(xpath = "//android.widget.FrameLayout[contains(@resource-id, 'fi.oikotie.internal:id/editText_password')]/android.view.ViewGroup/android.widget.EditText")
    var passwordField: WebElement? = null

    @FindBy(xpath = "//android.widget.FrameLayout[contains(@resource-id, 'fi.oikotie.internal:id/existingPassword')]/android.view.ViewGroup/android.widget.EditText")
    var existingPasswordField: WebElement? = null

    @FindBy(xpath = "//android.widget.FrameLayout[contains(@resource-id, 'fi.oikotie.internal:id/newPassword')]/android.view.ViewGroup/android.widget.EditText")
    var newPasswordField: WebElement? = null

    @FindBy(xpath = "//android.widget.FrameLayout[contains(@resource-id, 'fi.oikotie.internal:id/confirmPassword')]/android.view.ViewGroup/android.widget.EditText")
    var repeatPasswordField: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/switch_consent")
    var hyvaksynOikotienKayttoehdotJaTietosuojalausekkeenSwitch: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/textView_errorText")
    var sahkopostiosoiteOnJoRekisteroity: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/button_signup")
    var luoUusiOikotieTunnusButton: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/button_login")
    var kirjauduOikotieTunnuksillaButton: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/button_clearEmail")
    var clearEmailButton: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/button_continue")
    var continueButton: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/button_login")
    var jatkaButton: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/menu_settings")
    var menuSettingsButton: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/button_logOut")
    var logoutButton: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/closeButton")
    var suljeButton: WebElement? = null
}