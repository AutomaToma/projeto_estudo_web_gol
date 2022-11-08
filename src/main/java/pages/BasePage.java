package pages;

import core.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver = DriverFactory.getDriver();
    JavascriptExecutor js;

    public void espera(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* Usado para Text, check ou radio*/

    public boolean esperarElementoEstarVisivel(WebElement webElement, int seconds) {
        boolean result = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOf(webElement));
            result = true;
        } catch (Exception e) {
            espera(3);
        }
        return result;
    }

    /* Usado para Links e botões*/

    public boolean esperarElementoEstarClicavel(WebElement webElement, int seconds) {
        boolean result = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            result = true;
        } catch (Exception e) {
            espera(3);
        }
        return result;
    }

    /* -----------METODOS SCROLL----------- */

    public void rolarAteOElemento(WebElement elemento) {
        try {
            //Espera o elemento antes de rolar até o mesmo
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(elemento));

            //Rola até o elemento
            Actions actions = new Actions(driver);
            actions.scrollFromOrigin(WheelInput.ScrollOrigin.fromElement(elemento), 0, 400);
            actions.perform();

        } catch (Exception e) {
            System.out.println("Não foi possível rolar até o elemento ");

        }

    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void rolarParaBaixo() {

        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromViewport(10, 10);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 800)
                .perform();
        System.out.println("Rolou 800 pixels para baixo...");
    }

    public void rolarParaBaixo(int x, int y) {

        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromViewport(10, 10);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, x, y)
                .perform();
        System.out.println("Rolou 800 pixels para baixo...");
    }


    /* ----------- MODAL ----------- */
    public void aguardarModalSairDaTela() {
        WebElement modal = driver.findElement(By.xpath("//span[contains(@class, 'a-icon a-icon--bf-airplane m-airplane-load__icon m-airplane-load__icon--animation')]"));

        try {
            while (modal.isDisplayed()) {
                System.out.println("Modal sendo apresentado...");

                if (!modal.isDisplayed()) {
                    return;
                }
            }
        } catch (Exception e) {
            espera(3);
        }

    }

}
