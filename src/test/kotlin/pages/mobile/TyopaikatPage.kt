package pages.mobile

import elements.mobile.TyopaikatPageElements
import org.testng.Assert

class TyopaikatPage : TyopaikatPageElements() {

    fun verifyTitle(title: String?) {
        Assert.assertEquals(toolbarTitleTextView?.text, title)
    }
}

