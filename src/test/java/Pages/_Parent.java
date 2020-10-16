/**
 * @Author:Otosun Tarih :05/10/2020
 */
package Pages;

import Utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class _Parent {
    /**
     * Bu dosya diğer bütün page ler için ortak click ve sendkeys
     * için nekleme, scroll ve clear gibi bütün işleleri tek yereden
     * yapabilmek için eklendi.Bu class diğer pageler tarafından exten edilerek
     * kullanılacak.Böylece tüm pagelerdeki elemanların click ve sendkeys özelliği
     * hem bekleme hem scroll hem de clear özelliği kazanmış olacak.
     */

    WebDriver driver;
    WebDriverWait wait;
    List<WebElement> myList = new ArrayList<>();
    WebElement myElement;

    public _Parent() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }


    public void clickFunction(WebElement element) {
        waitUntilClickable(element);// eleman clikable olana kadar bekle
        scrollToElement(element); // eleman kadar scroll yap
        element.click();// click yap
    }

    public void sendKeysFunction(WebElement element, String value) {
        waitUntilVisible(element);// elelman görünüt olana kadar bekle
        scrollToElement(element);// elemana kadar scroll yap
        element.clear();// eleman clear yap
        element.sendKeys(value);// value yi gönder
    }

    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilToBeSelected(WebElement element) {
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void verifyElementContainsText(WebElement element, String text) {
        // waitUntilVisible(element);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        //   System.out.println(element.getText());
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));
    }

    public List<WebElement> waitVisibleListAllElement(List<WebElement> elementList) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        return elementList;
    }

    public void beklet(int milisaniye) {
        try {
            Thread.sleep(milisaniye);
        } catch (Exception ie) {
            ie.printStackTrace();
        }
    }

    public boolean girdiSayiMi(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public void selectOptionByString(List<WebElement> elementList, String str) {
        str = str.trim();
        if (girdiSayiMi(str)) {
            clickFunction(selectOptions(elementList, Integer.parseInt(str)));
        } else {
            clickFunction(selectOptions(elementList, str));
        }
    }

    public WebElement selectOptions(List<WebElement> elementList, String value) {
        WebElement elementSelected = null;
        for (WebElement element : elementList) {
            if (element.getText().equalsIgnoreCase(value)) {
                elementSelected = element;
                break;
            }
        }
        return elementSelected;
    }

    public WebElement selectOptions(List<WebElement> elementList, int index) {
        return elementList.get(index);
    }
}
