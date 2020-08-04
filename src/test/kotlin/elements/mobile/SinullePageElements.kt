package elements.mobile

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import pages.mobile.CommonPage


open class SinullePageElements : CommonPage() {

    @FindBy(id = "textView_introTop")
    var textViewIntroTop: WebElement? = null

    @FindBy(id = "android:id/sem_title_default")
    var semTitleDefault: WebElement? = null

    @FindBy(id = "textView_titleTop")
    var textViewTitleTop: WebElement? = null

    @FindBy(id = "fi.oikotie.internal:id/imageView_spotContentBig")
    var imageViewSpotContentBig: WebElement? = null
}