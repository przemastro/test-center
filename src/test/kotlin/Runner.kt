
import cucumber.api.CucumberOptions
import cucumber.api.testng.AbstractTestNGCucumberTests

@CucumberOptions(plugin = ["io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"],
        features = ["src/test/kotlin/features/mobile/ui/"],
        glue = ["steps/mobile/ui"],
        tags = ["@smokeTest"])
class Runner : AbstractTestNGCucumberTests() {

}
