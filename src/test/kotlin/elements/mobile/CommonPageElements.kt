package elements.mobile

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

open class CommonPageElements {

    @FindBy(xpath = "//android.view.ViewGroup[contains(@resource-id, 'fi.oikotie.internal:id/toolBar')]/android.widget.ImageButton")
    var returnButton: WebElement? = null

    @FindBy(id = "imageButton_favorite")
    var favouriteIcon: WebElement? = null

    @FindBy(id = "titleTextView")
    var screenTitle: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/menu_share")
    var shareIcon: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/menu_add_as_favorite")
    var favIconTR: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/imageView_image")
    var imageViewButton: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/imageButton_scrollUp")
    var scrollUpButton: WebElement? = null

    @FindBy(xpath = "//*[contains(@text, 'OTA YHTEYTTÄ')]")
    var titleOnOtaYhteytta: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/imageButton_sendMessage")
    var lahetaViestiIcon: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/toolbarTitleTextView")
    var titleOnLahetaViesti: WebElement? = null

    @FindBy(id = "imageView_searchApartments")
    var asunnotButton: WebElement? = null

    @FindBy(xpath = "//*[contains(@text, 'Haku')]")
    var hakuButton: WebElement? = null

    @FindBy(xpath = "//*[contains(@text, 'Sinulle')]")
    var sinulleButton: WebElement? = null

    @FindBy(xpath = "//*[contains(@text, 'Tapahtumat')]")
    var tapahtumatButton: WebElement? = null

    @FindBy(xpath = "//*[contains(@text, 'Profiili')]")
    var profiiliButton: WebElement? = null

    @FindBy(id = "imageView_searchJobs")
    var tyopaikatButton: WebElement? = null

    @FindBy(id = "android:id/button2")
    var eiButton: WebElement? = null

    @FindBy(id = "android:id/button1")
    var kyllaButton: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/closeButton")
    var eiKiitosButton: WebElement? = null

    @FindBy(id = "loginButton")
    var tallennaButton: WebElement? = null

    @FindBy(id = "button")
    var kohteenTiedotButton: WebElement? = null

    @FindBy(id = "button")
    var lahetaViestiButton: WebElement? = null

    @FindBy(id = "android:id/button2")
    var peruutaButton: WebElement? = null

    @FindBy(id = "android:id/button1")
    var kirjaudoUlosButton: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/button_facebookLogin")
    var kirjauduFacebookTunnuksillaButton: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/button_login")
    var kirjauduTaiLuoTunnus: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/inputField")
    var emailInputField: WebElement? = null
}