package pageobjects;

import models.UserRegistration;
import org.openqa.selenium.By;

public class UserRegistrationPage extends PageObject {

    private By mr = By.cssSelector("#id_gender1");
    private By mrs = By.cssSelector("#id_gender2");
    private By customerFirstName = By.cssSelector("#customer_firstname");
    private By customerLastName = By.cssSelector("#customer_lastname");
    private By email = By.cssSelector("#email");
    private By password = By.cssSelector("#passwd");
    private By day = By.cssSelector("#days");
    private By month = By.cssSelector("#months");
    private By year = By.cssSelector("#years");
    private By newsletter = By.cssSelector("#newsletter");
    private By specialOffers = By.cssSelector("#optin");
    private By firstName = By.cssSelector("#firstname");
    private By lastName = By.cssSelector("#lastname");
    private By company = By.cssSelector("#company");
    private By address1 = By.cssSelector("#address1");
    private By address2 = By.cssSelector("#address2");
    private By city = By.cssSelector("#city");
    private By state = By.cssSelector("#id_state");
    private By postcode = By.cssSelector("#postcode");
    private By country = By.cssSelector("#id_country");
    private By addlInfo = By.cssSelector("#other");
    private By homePhone = By.cssSelector("#phone");
    private By mobilePhone = By.cssSelector("#phone_mobile");
    private By addressAlias = By.cssSelector("#alias");
    private By register = By.cssSelector("#submitAccount");


    public void completeUserRegistrationForm(UserRegistration userRegistration)
    {


    }


}
