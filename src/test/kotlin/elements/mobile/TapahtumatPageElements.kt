package elements.mobile

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import pages.mobile.CommonPage


open class TapahtumatPageElements : CommonPage() {

    @FindBy(id = "fi.oikotie.internal:id/textView_title")
    var textViewTitle: WebElement? = null
}