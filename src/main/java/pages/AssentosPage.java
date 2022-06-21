package pages;

import core.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssentosPage {
    WebDriver driver = DriverFactory.getDriver();


    public AssentosPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//h1[contains(text(), 'Escolha os assentos')]")
    WebElement tituloEscolhaAssentos;

    @FindBy (xpath = "(//button[contains(text(), 'Selecione os assentos')])[1]")
    WebElement selecionarAssentosIda;

    @FindBy (xpath = "(//button[contains(text(), 'Selecione os assentos')])[2]")
    WebElement selecionarAssentosVolta;

    @FindBy (xpath = "//button[text() = ' 4B ']")
    WebElement assentoSelecionadoIda;

    @FindBy (xpath = "(//button[contains(text(), 'Finalizar marcação de assento')])[1]")
    WebElement finalizarMarcacaoAssentoIda;

    @FindBy (xpath = "//button[text() = ' 4B ']")
    WebElement assentoSelecionadoVolta;

    @FindBy (xpath = "(//button[contains(text(), 'Finalizar marcação de assento')])[2]")
    WebElement finalizarMarcacaoAssentoVolta;

    @FindBy (xpath = "//button[contains(text(), 'Ir para Personalize sua viagem')]")
    WebElement personalizeSuaViagem;

    //MÉTODOS

    public void validarPagina() {
        Assert.assertEquals("Escolha os assentos", tituloEscolhaAssentos.getText());
    }

    public void escolherAssentos() {
        selecionarAssentosIda.click();
        assentoSelecionadoIda.click();
        finalizarMarcacaoAssentoIda.click();
        selecionarAssentosVolta.click();
        assentoSelecionadoVolta.click();
        finalizarMarcacaoAssentoVolta.click();
        personalizeSuaViagem.click();

    }






}
