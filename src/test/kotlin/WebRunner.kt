
import cucumber.api.CucumberOptions
import cucumber.api.testng.AbstractTestNGCucumberTests

@CucumberOptions(plugin = ["io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"],
        features = ["src/test/kotlin/features/web/ui/"],
        glue = ["steps/web/ui"],
        tags = ["@webUiTest"])
class WebRunner : AbstractTestNGCucumberTests() {

}