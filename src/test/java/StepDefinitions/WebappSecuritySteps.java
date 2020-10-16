/**
 * @Author:Otosun Tarih :16/10/2020
 */
package StepDefinitions;

import Pages.PayContent;
import Utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WebappSecuritySteps {
    WebDriver driver;
    PayContent payContent=new PayContent();

    @Given("^Navigate to webappsecurity$")
    public void navigateToWebappsecurity() {
        driver = Driver.getDriver();
        driver.get("http://zero.webappsecurity.com/login.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("^Enter username and password, click Login button$")
    public void enterUsernameAndPasswordClickLoginButton() {
        payContent.findElementAndSendKeysFunction("userLogin","username");
        payContent.findElementAndSendKeysFunction("userPassword","password");
        payContent.findElementAndClickFunction("submitButton");
        driver.switchTo().alert().accept();
    }

    @Then("^User should login successfully$")
    public void userShouldLoginSuccessfully() {
        driver.switchTo().alert().accept();
    }
}
