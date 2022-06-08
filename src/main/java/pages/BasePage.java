package pages;

import core.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver  = DriverFactory.getDriver();

    public void espera(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* Usado para Text, check ou radio*/
//    public void esperarElementoEstarVisivel(WebDriver driver, WebElement webElement, int seconds) {
//       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
//       wait.until(ExpectedConditions.visibilityOf(webElement));
//    }

//    OUTRAS FORMAS DE ESPERA

    public boolean esperarElementoEstarVisivel(WebElement webElement, int seconds) {
        boolean result = false;
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOf(webElement));
            result = true;
        } catch (Exception e) {
            espera(3);
        }
        return result;
    }

    /* Usado para Links e botões*/
    public void esperarElementoEstarClicavel(WebDriver driver, WebElement webElement, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));

    }
}
