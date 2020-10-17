/**
 * @Author:Otosun Tarih :16/10/2020
 */
package StepDefinitions;

import Pages.PayContent;
import Utilities.Driver;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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
      //  driver.switchTo().alert().accept();
    }

    @Then("^User should login successfully$")
    public void userShouldLoginSuccessfully() {
        driver.switchTo().alert().accept();
    }

    @When("^Click Paybill and newPayee$")
    public void clickPaybillAndNewPayee() {
        payContent.findElementAndClickFunction("payBill");
        payContent.findElementAndClickFunction("addNewPayee");
    }

    @And("^Send \"([^\"]*)\"to Paye name$")
    public void sendToPayeName(String arg0) {
       payContent.findElementAndSendKeysFunction("newPayeeName",arg0);
    }

    @Then("^Send \"([^\"]*)\"to Payee Address$")
    public void sendToPayeeAddress(String arg0){
        payContent.findElementAndSendKeysFunction("payAddress",arg0);
    }

    @Then("^Send \"([^\"]*)\"to Account$")
    public void sendToAccount(String arg0) {
        payContent.findElementAndSendKeysFunction("account",arg0);
    }

    @Then("^Send \"([^\"]*)\"to Payee Details$")
    public void sendToPayeeDetails(String arg0){
        payContent.findElementAndSendKeysFunction("payeDetailes",arg0);
    }

    @And("^Save to form$")
    public void saveToForm() {
        payContent.findElementAndClickFunction("payeAddButton");
    }

    @Then("^Success message shuld be diplayed$")
    public void successMessageShuldBeDiplayed() {

    payContent.findElementAndVerifyContainsText("success","successfully");
    }

    @Then("^Verify success message not displayed$")
    public void verifySuccessMessageNotDisplayed() {
        Assert.assertFalse(payContent.success.isDisplayed());

    }

    @When("^Click Paybill and purchase foreing currency$")
    public void clickPaybillAndPurchaseForeingCurrency() {
        payContent.findElementAndClickFunction("payBill");
        payContent.findElementAndClickFunction("purchaseForeignCurrency");
    }

    @And("^Select currency \"([^\"]*)\" and enter amount as \"([^\"]*)\"$")
    public void selectCurrencyAndEnterAmountAs(String arg0, String arg1){
        payContent.findElementAndClickFunction("pcCurrency");
        payContent.findElementAndSelectOption("option",arg0);
        payContent.findElementAndSendKeysFunction("pcAmount",arg1);

    }

    @Then("^Choose whether the currency will be \"([^\"]*)\" and calculated$")
    public void chooseWhetherTheCurrencyWillBeAndCalculated(String arg0){
        if (arg0.equalsIgnoreCase("dollar")){
            payContent.findElementAndClickFunction("pcDollarTrue");
        }
        else {
            payContent.findElementAndClickFunction("pcDollarFalse");
        }
        payContent.findElementAndClickFunction("pcCalculateButton");
        payContent.beklet(1000);
        payContent.findElementAndClickFunction("puschaseButton");

    }


}
