package pages;

import core.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public void espera(int segundos){
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public void esperarElementoEstarVisivel(WebElement element, int timeout){
//        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeout);
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }
//
//    public void waitUntilElementVisible(WebElement element, Integer timeoutSeconds) {
//        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeoutSeconds);
//        wait.until(ExpectedConditions.visibilityOfAllElements(element));
//    }
//
//    public void waitUntilElementVisible(WebElement element) {
//        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
//        wait.until(ExpectedConditions.visibilityOfAllElements(element));
//    }

    /* Usado para Text, check ou radio*/
    public WebElement esperarElementoEstarVisivel(WebDriver driver, WebElement webElement, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(webElement));
        return element;
    }
    /* Usado para Links e botões*/
    public WebElement esperarElementoEstarClicavel(WebDriver driver, WebElement webElement, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return element;
    }
}
