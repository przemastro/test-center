package elements.mobile

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import pages.mobile.CommonPage


open class TyopaikatPageElements : CommonPage() {

    @FindBy(id = "fi.oikotie.internal:id/toolbarTitleTextView")
    var toolbarTitleTextView: WebElement? = null

}