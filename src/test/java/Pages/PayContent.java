/**
 * @Author:Otosun Tarih :16/10/2020
 */
package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PayContent extends _Parent{

    @FindBy(css = "input[id='user_login']")
    private WebElement userLogin;

    @FindBy(css = "input[id='user_password']")
    private WebElement userPassword;

    @FindBy(css = "input[name='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "(//ul[@class='nav nav-tabs']/li)[4]")
    private WebElement payBill;

    @FindBy(xpath = "//a[text()='Add New Payee']")
    private WebElement addNewPayee;

    @FindBy(xpath = "//a[text()='Purchase Foreign Currency']")
    private WebElement purchaseForeignCurrency;

    @FindBy(xpath = "//input[@id='np_new_payee_name']")
    private WebElement newPayeeName;

    @FindBy(xpath = "//textarea[@id='np_new_payee_address']")
    private WebElement payAddress;

    @FindBy(xpath = "//input[@id='np_new_payee_account']")
    private WebElement account;

    @FindBy(xpath = "//input[@id='np_new_payee_details']")
    private WebElement payeDetailes;

    @FindBy(xpath = "//input[@id='add_new_payee']")
    private WebElement payeAddButton;

    @FindBy(css = "div[id=alert_container]>div")
    public WebElement success;

    @FindBy(css = "select[id='pc_currency']")
    private WebElement pcCurrency;

    @FindBy(css = "input[id='pc_amount']")
    private WebElement pcAmount;

    @FindBy(css = "input[id='pc_inDollars_true']")
    private WebElement pcDollarTrue;

    @FindBy(css = "input[id='pc_inDollars_false']")
    private WebElement pcDollarFalse;

    @FindBy(css = "input[id='pc_calculate_costs']")
    private WebElement pcCalculateButton;

    @FindBy(css = "input[id='purchase_cash']")
    private WebElement puschaseButton;


    @FindAll({
            @FindBy(css = "select[id='pc_currency']>option")
    })
    private List<WebElement> option;

    public void findElementAndClickFunction(String elementName) {

        switch (elementName) {
            case "submitButton":
                myElement = submitButton;
                break;
            case "payBill":
                myElement = payBill;
                break;
            case "addNewPayee":
                myElement = addNewPayee;
                break;
            case "payeAddButton":
                myElement = payeAddButton;
                break;
            case "purchaseForeignCurrency":
                myElement = purchaseForeignCurrency;
                break;
            case "pcDollarTrue":
                myElement = pcDollarTrue;
                break;
            case "pcDollarFalse":
                myElement = pcDollarFalse;
                break;
            case "pcCalculateButton":
                myElement = pcCalculateButton;
                break;
            case "puschaseButton":
                myElement = puschaseButton;
                break;
            case "pcCurrency":
                myElement = pcCurrency;
                break;
        }
        clickFunction(myElement);
    }

    public void findElementAndSendKeysFunction(String ElementName, String value) {

        switch (ElementName) {
            case "userLogin":
                myElement = userLogin;
                break;
            case "userPassword":
                myElement = userPassword;
                break;
            case "newPayeeName":
                myElement = newPayeeName;
                break;
            case "payAddress":
                myElement = payAddress;
                break;
            case "account":
                myElement = account;
                break;
            case "payeDetailes":
                myElement = payeDetailes;
                break;
            case "pcAmount":
                myElement = pcAmount;
                break;
        }
        sendKeysFunction(myElement, value);
    }
    public void findElementAndSelectOption(String listName, String secenek) {
        switch (listName) {
            case "option":
                myList = option;
                break;
        }
        selectOptionByString(myList, secenek);
    }
    public void findElementAndVerifyContainsText(String elementName, String msg) {
        switch (elementName) {
            case "success":
                myElement = success;
                break;
        }
        verifyElementContainsText(myElement, msg);
    }
}
