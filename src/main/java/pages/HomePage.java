package pages;

import core.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver  = DriverFactory.getDriver();

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    // MAPEAMENTO DE ELEMENTO

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement buttonAceitarTermos;

    @FindBy(xpath = "(//fieldset[@class='a-icon a-input m-select__fieldset'])[1]")
    private WebElement selectTrecho;

    @FindBy(xpath = "//input[@id='input-saindo-de']")
    private WebElement inputOrigem;

    @FindBy(xpath = "//input[@id='input-indo-para']")
    private WebElement inputDestino;

    @FindBy(className = "m-list-cta__item")
    private WebElement optionAeroporto;

    @FindBy(xpath = "(//label[@class='a-input__label'])[4]")
    private WebElement selectPassageiros;


    // MÉTODOS

    public void validarHomePage(){

        if(buttonAceitarTermos.isDisplayed()){
            buttonAceitarTermos.click();
        }

        Assert.assertEquals("VoeGOL | Busca de voo", driver.getTitle());
    }

    public void selecionarTrecho(String tipoTrecho) throws InterruptedException {
        selectTrecho.click();

        //lista de trecho
        WebElement optionTipoTrecho = driver.findElement(By.xpath("//span[text()=' "+ tipoTrecho +" ']"));

        optionTipoTrecho.click();

    }

    public void digitarAeroportoOrigem(String aeroportoIda){
        inputOrigem.sendKeys(aeroportoIda);
        optionAeroporto.click();
    }

    public void digitarAeroportoVolta(String aeroportoVolta){
        inputDestino.sendKeys(aeroportoVolta);
        optionAeroporto.click();
    }


    public void buscarVoo(String tipoTrecho, String aeroportoIda, String aeroportoVolta) throws InterruptedException {
        selecionarTrecho(tipoTrecho);
        digitarAeroportoOrigem(aeroportoIda);
        digitarAeroportoVolta(aeroportoVolta);
    }

}
