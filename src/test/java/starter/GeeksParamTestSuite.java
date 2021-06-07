package starter;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import starter.stepdefinitions.GeeksSearchParamStepDefinitions;

//@RunWith(Suite.class)
//@Suite.SuiteClasses(GeeksSearchParamStepDefinitions.class)
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/search_geeks_param.feature"
)
public class GeeksParamTestSuite {
}
