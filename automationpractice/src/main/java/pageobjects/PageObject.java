package pageobjects;

import helpers.WebDriverHelper;
import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class PageObject {
    private Duration DRIVER_WAIT_TIME = Duration.ofSeconds(30);
    private static final Logger LOG = LoggerFactory.getLogger(PageObject.class);

    @Getter
    protected WebDriverWait wait;
    @Getter
    protected WebDriver webDriver;


    protected PageObject() {
        this.webDriver = WebDriverHelper.getWebDriver();
        if (webDriver == null) {
            LOG.debug("driver is null");
        } else {
            LOG.debug("the driver is not null");
        }
        this.wait = new WebDriverWait(webDriver, DRIVER_WAIT_TIME);
    }

    /**
     * Returns the current Url from page
     **/
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    /**
     * Returns the current page title from page
     */
    public String getCurrentPageTitle() {
        return getWebDriver().getTitle();
    }

    /**
     * Find the dynamic element wait until its visible
     *
     * @param by Element location found by css, xpath, id etc...
     **/
    protected WebElement waitForExpectedElement(final By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

}
