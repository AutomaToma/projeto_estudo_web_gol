package pages;

import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver  = DriverFactory.getDriver();
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

    public boolean esperarElementoEstarClicavel(WebElement webElement, int seconds) {
        boolean result = false;
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            result = true;
        } catch (Exception e) {
            espera(3);
        }
        return result;
    }

    /* -----------METODOS SCROLL----------- */

    public void rolarAteOElemento(WebElement elemento){
        try {
            //Espera o elemento antes de rolar até o mesmo
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOf(elemento));

            //Rola até o elemento
            Actions actions = new Actions(driver);
            actions.scrollToElement(elemento);
            actions.perform();

            int index1 = elemento.toString().indexOf("->");
            System.out.println("Scroll para o elemento: " + elemento.toString().substring(index1).replace("]", ""));
        }catch (Exception e){
            System.out.println("Não foi possível rolar até o elemento ");

        }

    }

    public void rolarParaBaixo(){
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromViewport(10, 10);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 400)
                .perform();
        System.out.println("Rolou 400 pixels para baixo...");
    }

    /* ----------- MODAL ----------- */
    public void aguardarModalSairDaTela(){
        WebElement modal = driver.findElement(By.xpath("//span[contains(@class, 'a-icon a-icon--bf-airplane m-airplane-load__icon m-airplane-load__icon--animation')]"));

        while (modal.isDisplayed()){
            System.out.println("Modal sendo apresentado...");
        }

        espera(12);

    }

}
