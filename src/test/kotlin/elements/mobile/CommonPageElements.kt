package elements.mobile

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

open class CommonPageElements {

    @FindBy(id = "some_id")
    var someIcon: WebElement? = null

}