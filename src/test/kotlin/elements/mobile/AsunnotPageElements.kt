package elements.mobile

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import pages.mobile.CommonPage


open class AsunnotPageElements : CommonPage() {

    @FindBy(id = "fi.oikotie.internal:id/toolbarTitleTextView")
    var toolbarTitleTextView: WebElement? = null

    @FindBy(id = "button_contact")
    var contactButton: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/button_info")
    var infoButton: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/button_pricing")
    var pricingButton: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/button_services")
    var servicesButton: WebElement? = null

    @FindBy(id = "button_contact")
    var otaYhteyttaButton: WebElement? = null

    @FindBy(id = "button")
    var naytaHakutuloksetButton: WebElement? = null
}