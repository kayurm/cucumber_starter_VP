package starter;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import starter.stepdefinitions.GeeksSearchParamStepDefinitions;

//@RunWith(CucumberWithSerenity.class)
@RunWith(Suite.class)
//@CucumberOptions(
//        plugin = {"pretty"},
//        features = "src/test/resources/features/search_geeks_param.feature"
//)
@Suite.SuiteClasses(GeeksSearchParamStepDefinitions.class)
public class GeeksParamTestSuite {
}
