package mySample.base;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public abstract class BaseSteps extends UIInteractionSteps {

    protected final Logger LOG = Logger.getLogger(getClass());

    @Step
    public void switchTab(WebDriver driver){
        String currentWindowHandle = driver.getWindowHandle();
        ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        for (String window : windowHandles) {
            if (!window.equals(currentWindowHandle)) {
                driver.switchTo().window(window);
            }
        }
    }
}
