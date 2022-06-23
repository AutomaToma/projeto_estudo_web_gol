package pages;

import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver  = DriverFactory.getDriver();
    JavascriptExecutor js = (JavascriptExecutor) driver;

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

//ROLAR X PIXELS BAIXO 0,250 CIMA 0,-250
    public void rolarParaBaixo(){
        js.executeScript("window.scrollBy(0, 450)");
        System.out.println("Scroll de 350 pixels" );
    }

    public void rolarPara(WebElement element){
        js.executeScript("arguments[0].scrollIntoView();", element);

        int index1 = element.toString().indexOf("id: ");
        System.out.println("Scroll para o elemento: "+ element.toString().substring(index1).replace("]","") );
    }

    public void rolarParaTexto(String texto) {
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.partialLinkText(texto)));
        System.out.println("Scroll para o texto: "+ texto );
    }
    /* ---------------------- */

    /* ----------- MODAL ----------- */
    public void aguardarModalSairDaTela(){
        WebElement modal = driver.findElement(By.xpath("//span[contains(@class, 'a-icon a-icon--bf-airplane m-airplane-load__icon m-airplane-load__icon--animation')]"));

        while (modal.isDisplayed()){
            System.out.println("Modal sendo apresentado...");
        }

        espera(12);

    }

}
