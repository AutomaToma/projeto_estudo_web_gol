package pages;

import core.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class HomePage extends BasePage{

    WebDriver driver  = DriverFactory.getDriver();
    CalendarioPage calendarioPage = new CalendarioPage();
    Utils utils = new Utils();


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

    @FindBy(id = "departureDate")
    private WebElement inputDataIda;

    @FindBy(id = "returnDate")
    private WebElement inputDataVolta;

    @FindBy(xpath = "(//button[text()=' Buscar voos '])[1]")
    private WebElement buttonBuscarVoo;

    // MÉTODOS

    public void validarHomePage(){
        espera(2);
        if(buttonAceitarTermos.isDisplayed()){
            buttonAceitarTermos.click();
        }

        Assert.assertEquals("VoeGOL | Busca de voo", driver.getTitle());
    }

    public void selecionarTrecho(String tipoTrecho) {
        //aguardarModalSairDaTela();
        //esperarElementoEstarClicavel(selectTrecho,10);
        espera(2);
        selectTrecho.click();

        espera(2);

        //lista de trecho
        WebElement optionTipoTrecho = driver.findElement(By.xpath("//span[contains(text(),'"+ tipoTrecho +"')]")); //antigo://span[text()=' Só ida ou Volta ']}]

        optionTipoTrecho.click();

    }

    public void digitarAeroportoOrigem(String aeroportoIda){
        espera(4);
        inputOrigem.sendKeys(aeroportoIda);
        optionAeroporto.click();
    }

    public void digitarAeroportoVolta(String aeroportoVolta){
        espera(4);
        inputDestino.sendKeys(aeroportoVolta);
        optionAeroporto.click();
    }

    public void buscarVoo(String tipoTrecho, String aeroportoIda, String aeroportoVolta, String dataIda, String dataVolta)  {
        selecionarTrecho(tipoTrecho);
        digitarAeroportoOrigem(aeroportoIda);
        digitarAeroportoVolta(aeroportoVolta);

        espera(1);

        if (tipoTrecho.toLowerCase().equals("só ida ou volta")){
            esperarElementoEstarVisivel(inputDataIda,10);
            espera(3);
            inputDataIda.click();
            calendarioPage.selecionarDataDeIda(dataIda);
        }
        else if (tipoTrecho.toLowerCase().equals("ida e volta")){
            inputDataIda.click();
            calendarioPage.selecionarDataDeIda(dataIda);
            // TODO implementar selecionar data de volta
        }
        else{
            // TODO implementar Multi-trecho
        }
        //aguardarModalSairDaTela();
        esperarElementoEstarVisivel(buttonBuscarVoo,10);
        esperarElementoEstarClicavel(buttonBuscarVoo,10);
        buttonBuscarVoo.click();

    }

}
