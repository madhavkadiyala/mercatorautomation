package pageobjects;

import org.openqa.selenium.By;

public class HomePage extends PageObject {

    private By signin = By.cssSelector("a.login");

    public void clickOnSignIn() {
        waitForExpectedElement(signin).click();
    }
}
