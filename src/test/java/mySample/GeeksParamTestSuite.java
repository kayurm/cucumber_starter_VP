package mySample;

import io.cucumber.junit.CucumberOptions;
import mySample.stepdefinitions.GeeksSearchParamStepDefs;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//@RunWith(Suite.class)
//@Suite.SuiteClasses(GeeksSearchParamStepDefs.class)
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/search_geeks_param.feature"
)
public class GeeksParamTestSuite {
}
