package elements.mobile

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import pages.mobile.CommonPage

open class ExamplePageElements : CommonPage() {

    @FindBy(id = "some_id")
    var someElement: WebElement? = null
}