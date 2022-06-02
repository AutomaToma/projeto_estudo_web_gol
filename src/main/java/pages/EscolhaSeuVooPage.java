package pages;

import core.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EscolhaSeuVooPage extends BasePage {

    private WebDriver driver = DriverFactory.getDriver();

    public EscolhaSeuVooPage() {
        PageFactory.initElements(driver, this);
    }

    // ------ MAPEAMENTO ------

    @FindBy(xpath = "//h1[contains(text(), 'Escolha o seu voo')]")
    private WebElement titleEscolhaSeuVoo;

    @FindBy(xpath = "(//div[contains(@class,'p-select-flight__accordion')]//div[contains(@aria-controls,'flight-')])[1]")
    private WebElement cardVoo;

    @FindBy(xpath = "//button[text()='Continuar para login']")
    private WebElement buttonContinuarParaLogin;


    // ------ MÉTODOS ------

    public void validarPaginaEscolhaSeuVoo() {
//        esperarElementoEstarVisivel(driver, titleEscolhaSeuVoo, 10);
        espera(2);
        Assert.assertTrue(titleEscolhaSeuVoo.getText().contains("Escolha o seu voo"));
    }

    public void selecionarVooETarifa(String tarifa) {
        cardVoo.click();

        espera(4);

        WebElement cardVooETarifa = DriverFactory.getDriver().findElement(By.xpath("(//h2[text()='" + tarifa + "']//following::div[@class='m-card__body'][1]//span)[1]"));

        if(cardVooETarifa.getText().contains("Tarifa selecionada")){
            buttonContinuarParaLogin.click();
        }else {
            espera(2);
            cardVooETarifa.click();
            buttonContinuarParaLogin.click();
        }

        espera(5);
    }


}
