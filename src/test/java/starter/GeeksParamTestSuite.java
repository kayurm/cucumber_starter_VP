package starter;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

//@RunWith(Suite.class)
//@Suite.SuiteClasses(GeeksSearchParamStepDefs.class)
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/search_geeks_param.feature"
)
public class GeeksParamTestSuite {
}
