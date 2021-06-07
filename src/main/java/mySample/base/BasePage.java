package mySample.base;

import net.thucydides.core.pages.PageObject;
import org.apache.log4j.Logger;

public abstract class BasePage extends PageObject {

    protected final Logger LOG = Logger.getLogger(getClass().getSimpleName());
}
