package elements.mobile

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import pages.mobile.CommonPage


open class HakuPageElements : CommonPage() {

    @FindBy(id = "textView_searchTitle")
    var textViewSearchTitle: WebElement? = null

    @FindBy(xpath = "//android.widget.FrameLayout[contains(@resource-id, 'fi.oikotie.internal:id/layout_mapContainer')]/android.widget.FrameLayout")
    var asunnotLaheltaMapContainerButton: WebElement? = null
}