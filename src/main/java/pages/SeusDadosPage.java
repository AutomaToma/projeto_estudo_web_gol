package pages;

import core.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class SeusDadosPage extends BasePage {

    private WebDriver driver = DriverFactory.getDriver();
    Utils utils = new Utils();

    public SeusDadosPage() {
        PageFactory.initElements(driver, this);
    }

    //MAPEAMENTO

    @FindBy(xpath = "//h1[contains(text(),'Para continuar se' )]")
    private WebElement tituloPagina;

    @FindBy(xpath = "//input[@id='guest-login']//parent::div")
    private WebElement radioContinuarSemLogin;

    @FindBy(xpath = "//button[contains(text(),'Ir para dados')]")
    private WebElement btnIrParaDadosDoPassageiro;

    //MÉTODOS

    public void validarSeusDadosPage(){
        espera(2);
        Assert.assertEquals("Para continuar se\n" +
                "identifique",tituloPagina.getText());
    }

    public void selecionarSemLogin(){
        aguardarModalSairDaTela();
        esperarElementoEstarVisivel(radioContinuarSemLogin,20);
        espera(5);
        radioContinuarSemLogin.click();
    }

    public void clicarIrParaDadosDoPassageiro(){
        btnIrParaDadosDoPassageiro.click();
    }

}