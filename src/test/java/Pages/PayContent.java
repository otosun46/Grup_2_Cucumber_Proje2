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



    @FindAll({
            @FindBy(css = "mat-option[role='option']")
    })
    private List<WebElement> option;

    public void findElementAndClickFunction(String elementName) {

        switch (elementName) {
            case "submitButton":
                myElement = submitButton;
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

}
